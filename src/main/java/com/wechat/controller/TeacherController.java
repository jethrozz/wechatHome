package com.wechat.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wechat.bean.AccessToken;
import com.wechat.bean.MyClass;
import com.wechat.bean.TeacherHomeworkResult;
import com.wechat.common.controller.BaseController;
import com.wechat.dao.ClassesDao;
import com.wechat.entity.*;
import com.wechat.mapper.ClassesMapper;
import com.wechat.mapper.TeacherClassMapper;
import com.wechat.model.CommonResult;
import com.wechat.model.NoticeTemplateQueue;
import com.wechat.model.Template;
import com.wechat.model.TemplateParam;
import com.wechat.service.StudentService;
import com.wechat.service.TeacherService;
import com.wechat.service.TemplateService;
import com.wechat.util.DateUtil;
import com.wechat.util.HttpUtil;
import com.wechat.util.OfficeUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@Transactional
public class TeacherController extends BaseController {


    @Autowired
    private ClassesMapper classesMapper;
    @Autowired
    private TeacherClassMapper teacherClassMapper;
    @Autowired
    private ClassesDao classesDao;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;


    @ApiOperation(value = "新建班级信息接口",notes = "",produces = "application/json")
    @ApiImplicitParam(name = "classes",
                    value = "需要添加的班级实体Classes",
                    required = true, dataType = "Classes")
    @RequestMapping(value = "/addClasses",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public CommonResult<Object> addClasses(@RequestBody Classes classes){
        if (classesMapper.insert(classes) == 1){
            return new CommonResult<>(successcode,successMessage);
        }
        return  new CommonResult<>(errorcode,errorMessage);
    }


    @ApiOperation(value = "获取班级概况信息接口",notes = "",produces = "application/json")
    @ApiImplicitParam(name = "id",
            value = "教师id",
            required = true, dataType = "Integer")
    @GetMapping(value = "/getClassesInfo/{id}",produces = "application/json")
    public CommonResult<Object> getClassesInfo(@PathVariable("id") Integer id){
        //根据传入的教师id
        MyClass myClass = new MyClass();

        Classes classes = new Classes();
        Teacher teacher = new Teacher();
        Student student = new Student();
        TeacherClass teacherClass = new TeacherClass();
        EntityWrapper<Classes> ew = new EntityWrapper<>();
        ew.where("teacher = {0}",id);
        List<Classes> classesList = classes.selectList(ew);
        if(classesList.size()!= 0){
            //设置该教师的班级信息
            myClass.setMyclass(classesList.get(0));
            teacher = teacher.selectById(myClass.getMyclass().getTeacher());
            //设置该班班主任
            myClass.setHeadMaster(teacher);
            //设置该班学生
            myClass.setStudentList(student.selectList("cla_id = {0}",myClass.getMyclass().getId()));

            //封装该班教师
            List<Teacher> teachers = new ArrayList<>();
            List<TeacherClass> teacherClasses = teacherClass.selectList("cla_id = {0}",myClass.getMyclass().getId());
            for(TeacherClass t : teacherClasses){
                teachers.add(teacher.selectById(t.getTeaId()));
            }
            myClass.setTeacherList(teachers);

            return new CommonResult<>(successcode,myClass);
        }

        return new CommonResult<>(errorcode,errorMessage);
    }

    //批量上传学生接口
    @PostMapping("uploadStudent")
    public CommonResult<String> uploadStudent(MultipartFile file, HttpServletRequest request){
        if(file == null && file.isEmpty()){
            return new CommonResult(errorcode,"the file is empty");
        }
        InputStream in = null;

        try {
            in = file.getInputStream();
        } catch (IOException e) {
            return new CommonResult(errorcode,"get the InputStream is error");
        }

        Teacher teacher = (Teacher)request.getSession().getAttribute("user");
        Classes classes = teacherService.getClassByTeacherId(teacher);
        List<Student> list = OfficeUtil.readStudent(in,1,classes.getId());
        for(Student student:list){
            student.insert();
        }
        return new CommonResult(0,"batch regist is susccess");
    }

    //批量上传成绩接口
    @PostMapping("/uploadStudentScore")
    public CommonResult<String> uploadStudentScore(MultipartFile file,HttpServletRequest request){
        if(file == null && file.isEmpty()){
            return new CommonResult(errorcode,"the file is empty");
        }
        InputStream in = null;

        try {
            in = file.getInputStream();
        } catch (IOException e) {
            return new CommonResult(errorcode,"get the InputStream is error");
        }
        List<ExamResult> list = OfficeUtil.readStudentScore(in,1,studentService);
        for (ExamResult result:list){
            result.insert();
        }

        return new CommonResult(0,"batch add examscore is susccess");
    }

    //获取教师信息接口
    @GetMapping("getTeacher/{id}")
    public CommonResult<Teacher> getTeacher(@PathVariable int id){
        Teacher teacher = new Teacher();
        teacher.selectById(id);
        return new CommonResult<Teacher>(0,teacher);
    }
    //发布作业接口
    @RequestMapping("/addHomework")
    public CommonResult<String> addHomework(HttpServletRequest request,int claId,String title,String content,String finshTime,int tid){
        Teacher teacher = (Teacher)request.getSession().getAttribute("user");
        Homework homework = new Homework();
        homework.setClaId(claId);
        homework.setTitle(title);
        homework.setContent(content);
        homework.setTeaId(teacher.getId());
        homework.setFinshTime(DateUtil.StringtoDate(finshTime,"yyyy-MM-dd"));
        homework.insert();

        return new CommonResult(0,"success");
    }
    //根据教师id获取所有作业
    @RequestMapping("/getHomeworkByTid")
    public CommonResult<List<TeacherHomeworkResult>> getHomeworkByTid(HttpServletRequest request,int tid){
        Teacher teacher = (Teacher)request.getSession().getAttribute("user");
        List<TeacherHomeworkResult> resultList = new ArrayList<>();
        Homework homework = new Homework();
        EntityWrapper<Homework> ew = new EntityWrapper<>();
        ew.where("tea_id = {0}",teacher.getId());
        List<Homework> list = homework.selectList(ew);

        for(Homework work:list){
            TeacherHomeworkResult t = new TeacherHomeworkResult();
            t.setHomework(work);
            Classes c = new Classes();
            c = c.selectById(work.getClaId());
            t.setClasses(c);
            resultList.add(t);
        }

        return new CommonResult(0,resultList);
    }

    //发布通知接口
    @PostMapping("/addNotice")
    public CommonResult<String> addNotice(HttpServletRequest request,NoticeBulletin notice){
        Teacher teacher = (Teacher)request.getSession().getAttribute("user");

        notice.setTeaId(teacher.getId());
        notice.insert();

        NoticeTemplateQueue.getInstance().addTemplate(notice);

        return new CommonResult(0,successMessage);
    }
}
