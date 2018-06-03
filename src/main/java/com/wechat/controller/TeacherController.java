package com.wechat.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.Page;
import com.wechat.bean.MyClass;
import com.wechat.bean.TableResult;
import com.wechat.common.controller.BaseController;
import com.wechat.dao.ClassesDao;
import com.wechat.dao.NoticeBulletinDao;
import com.wechat.dao.TeacherDao;
import com.wechat.entity.*;
import com.wechat.mapper.ClassesMapper;
import com.wechat.mapper.ExamResultMapper;
import com.wechat.mapper.TeacherClassMapper;
import com.wechat.model.CommonResult;
import com.wechat.model.NoticeTemplateQueue;
import com.wechat.service.StudentService;
import com.wechat.service.TeacherService;
import com.wechat.util.DateUtil;
import com.wechat.util.OfficeUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
@Transactional
public class TeacherController extends BaseController {


    @Autowired
    private ClassesMapper classesMapper;
    @Autowired
    private TeacherClassMapper teacherClassMapper;
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private ClassesDao classesDao;
    @Autowired
    private NoticeBulletinDao noticeDao;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    @Autowired
    private ExamResultMapper examResultMapper;


    @PostMapping("/userLogin")
    public CommonResult<Object> teacherLogin(HttpServletRequest request,Teacher teacher){
        List<Teacher> list = teacher.selectList("teacher_id = {0} and password = {1}",teacher.getTeacherId(),teacher.getPassword());
        if(list.size() != 0){
            request.getSession().setAttribute("user",list.get(0));
            return new CommonResult<>(successcode,list.get(0));
        }
        return new CommonResult<>(errorcode,"用户名或者密码错误");
    }


    @ApiOperation(value = "新建班级信息接口",notes = "",produces = "application/json")
    @ApiImplicitParam(name = "classes",
                    value = "需要添加的班级实体Classes",
                    required = true, dataType = "Classes")
    @PostMapping(value = "/addClasses")
    public CommonResult<Object> addClasses(HttpServletRequest request,Classes classes){
        Teacher teacher = (Teacher)request.getSession().getAttribute("user");
        if(teacher.getIsHeadmaster() == 0){
            return  new CommonResult<>(errorcode,"你已经是班主任了，不能再创建班级");
        }else{
            classes.setTeacher(teacher.getId());
            teacher.setIsHeadmaster(0);
            teacher.updateById();
            if (classesMapper.insert(classes) == 1){
                TeacherClass teacherClass = new TeacherClass();
                teacherClass.setClaId(classes.getId());
                teacherClass.setTeaId(teacher.getId());
                teacherClass.insert();
                return new CommonResult<>(successcode,successMessage);
            }
        }
        return  new CommonResult<>(errorcode,errorMessage);
    }


    @ApiOperation(value = "获取班级概况信息接口",notes = "",produces = "application/json")
    @ApiImplicitParam(name = "id",
            value = "教师id",
            required = true, dataType = "Integer")
    @GetMapping(value = "/getClassesInfo",produces = "application/json")
    public CommonResult<Object> getClassesInfo(HttpServletRequest request){
        //根据传入的教师id
        Teacher tea = (Teacher)request.getSession().getAttribute("user");
        MyClass myClass = new MyClass();

        Classes classes = new Classes();
        Teacher teacher = new Teacher();
        Student student = new Student();
        TeacherClass teacherClass = new TeacherClass();
        EntityWrapper<Classes> ew = new EntityWrapper<>();
        ew.where("teacher = {0}",tea.getId());
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

    @GetMapping("/getTeacherByClaId")
    public TableResult getTeacherByClaId(int  claId){
        List<Map<String,Object>> map = teacherDao.selectClassTeacher(claId);
        TableResult<Object> result = new TableResult<>();
        if(map == null || map.size() == 0){
            result.setCode(-1);
            result.setMsg("该班目前没有教师");
        }else{
            result.setCode(0);
            result.setData(map);
        }

        return result;
    }


    //批量上传成绩接口
    @PostMapping("/uploadStudentScore")
    public CommonResult<String> uploadStudentScore(String file,HttpServletRequest request){
        if(file == null ){
            return new CommonResult(errorcode,"the file is empty");
        }
        InputStream in = null;
        try {
            URL url = new URL(file);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            //得到输入流
            in = conn.getInputStream();

        } catch (IOException e) {
            return new CommonResult(errorcode,"get the InputStream is error");
        }
        boolean isExcel2003 = false;

        List<ExamResult> list = OfficeUtil.readStudentScore(in,1,studentService,false);
        for (ExamResult result:list){
            result.insert();
        }

        return new CommonResult(0,"batch add examscore is susccess");
    }

    //批量上传学生信息接口
    @PostMapping("/uploadStudentInfo")
    public CommonResult uploadStudentInfo(String file,HttpServletRequest request){
        if(file == null ){
            return new CommonResult(errorcode,"the file is empty");
        }
        InputStream in = null;
        try {
            URL url = new URL(file);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            //得到输入流
            in = conn.getInputStream();
        } catch (IOException e) {
            return new CommonResult(errorcode,"get the InputStream is error");
        }
        Teacher teacher = (Teacher) session.getAttribute("user");

        if (teacher == null){
            return new CommonResult(errorcode,errorMessage);
        }
        Classes classes = classesDao.selectByTeacherId(teacher.getId());
        List<Student> list = OfficeUtil.readStudent(in,1,classes.getId());
        for (Student result:list){
            result.insert();
        }
        return new CommonResult(0,"batch add student is susccess");
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
    public CommonResult<String> addHomework(HttpServletRequest request,int claId,String title,String content,String finshTime){
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
    public TableResult<Object> getHomeworkByTid(HttpServletRequest request,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int limit){
        Teacher teacher = (Teacher)request.getSession().getAttribute("user");
        TableResult<Object> result = new TableResult<>();
        Page<Map<String,Object>> mapList = teacherService.getHomework(teacher.getId(),page,limit);

        result.setCount((int)mapList.getTotal());
        result.setData(mapList);
        result.setCode(0);

        return result;
    }

    //发布通知接口
    @PostMapping("/addNotice")
    public CommonResult<String> addNotice(HttpServletRequest request,NoticeBulletin notice){
        //Teacher teacher = (Teacher)request.getSession().getAttribute("user");

        //notice.setTeaId(teacher.getId());
        notice.insert();

        NoticeTemplateQueue.getInstance().addTemplate(notice);

        return new CommonResult(0,successMessage);
    }

    //发布作业时需要的班级列表
    @RequestMapping("/getMyclassList")
    public CommonResult<Object> getMyclassList(HttpServletRequest request){
        Teacher teacher = (Teacher)request.getSession().getAttribute("user");
        TeacherClass teacherClass = new TeacherClass();
        List<Classes> classesList = new ArrayList<>();
        Classes classes = new Classes();
        List<TeacherClass> list = teacherClass.selectList("tea_id = {0}",teacher.getId());
        for(TeacherClass tc : list){
            classesList.add(classes.selectById(tc.getClaId()));
        }
        return new CommonResult(successcode,classesList);
    }

    //获取所有通知
    @RequestMapping("/getAllNotice")
    public TableResult<Object> getAllNotice(HttpServletRequest request, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int limit){
        TableResult<Object> result = new TableResult<>();
        result.setCode(0);
        result.setMsg("操作成功");
        Page<Map<String,Object>> mapPage = teacherService.getNotice(page,limit);
        NoticeBulletin notice = new NoticeBulletin();
        List<NoticeBulletin> list = notice.selectAll();
        result.setCount(list.size());
        result.setData(mapPage);
        return result;
    }
    //根据日期范围查询通知
    @RequestMapping("/getNoticeByTime")
    public CommonResult<Object> getNoticeByTime(HttpServletRequest request,String startTime,String endTime){
        List<Map<String,Object>> result = noticeDao.getAllNoticeByTime(startTime,endTime);
        return new CommonResult<>(successcode,result);
    }

    //上传单个学生成绩
    @RequestMapping("/addExamResult")
    public CommonResult<Object> addExamResult(HttpServletRequest request,ExamResult examResult){
        if(examResult.insert()){
            return new CommonResult<>(successcode,successMessage);
        }else{
            return new CommonResult<>(errorcode,errorMessage);
        }
    }

    //教师端获取请假记录
    @RequestMapping("/getLeaveRecord")
    public TableResult<Object> getLeaveRecord(HttpServletRequest request,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int limit){
        Teacher teacher = (Teacher)request.getSession().getAttribute("user");
        TableResult<Object> result = new TableResult<>();
        Page<Map<String,Object>> mapList = teacherService.getLeaverRecord(teacher.getId(),page,limit);
        result.setCode(0);
        result.setCount((int)mapList.getTotal());
        result.setData(mapList);
        return result;
    }
    //所有成绩
    @RequestMapping("/getExamResult")
    public TableResult<Object> getExamResult(HttpServletRequest request,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int limit){
        Teacher teacher = (Teacher)request.getSession().getAttribute("user");
        TableResult<Object> result = new TableResult<>();
        Page<Map<String,Object>> mapList = teacherService.getExamResult(teacher.getId(),page,limit);

        result.setCount((int)mapList.getTotal());
        result.setData(mapList);
        result.setCode(0);

        return result;
    }

    /**
     * 修改成绩
     * @param sid
     * @param score
     * @return
     */
    @RequestMapping(value = "/updateStudentScore")
    public CommonResult updateStudentScore(@RequestParam("sid") Integer sid,@RequestParam ("score") Float score){
        ExamResult examResult = new ExamResult();
        examResult.setId(sid);
        examResult.setScore(score);
        boolean flag = examResult.updateById();
        if (flag)
            return new CommonResult(successcode,successMessage);
        return new CommonResult(errorcode,errorMessage);
    }


    /**
     * 修改作业接口
     * @param id
     * @param title
     * @param content
     * @return
     */
    @RequestMapping(value = "/updateHomeWork")
    public CommonResult updateHomeWork(@RequestParam("id") Integer id,
                                       @RequestParam ("title") String title,
                                       @RequestParam("content") String content){
        Homework homework = new Homework();
        homework.setId(id);
        homework.setTitle(title);
        homework.setContent(content);
        boolean flag = homework.updateById();
        if (flag)
            return new CommonResult(successcode,successMessage);
        return new CommonResult(errorcode,errorMessage);
    }

    /**
     * 删除接口
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteHomeWork/{id}")
    public CommonResult deleteHomeWork(@PathVariable("id") Integer id){
        Homework homework = new Homework();
        homework.setId(id);
        boolean flag = homework.deleteById();
        if (flag)
            return new CommonResult(successcode,successMessage);
        return new CommonResult(errorcode,errorMessage);
    }

    /**
     * 请假记录状态变更接口
     * @return
     */
    @RequestMapping("/leaveRecordUpdate")
    public CommonResult leaveRecordUpdate(@RequestParam("id") Integer id,@RequestParam("isAgree") Integer isAgree){
        LeaveRecord leaveRecord = new LeaveRecord();
        leaveRecord.setId(id);
        leaveRecord.setIsAgree(isAgree);
        boolean flag = leaveRecord.updateById();
        if (flag)
            return new CommonResult(successcode,successMessage);
        return new CommonResult(errorcode,errorMessage);
    }
}
