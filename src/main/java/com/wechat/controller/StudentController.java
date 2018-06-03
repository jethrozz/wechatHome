package com.wechat.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.Page;
import com.wechat.bean.TableResult;
import com.wechat.common.controller.BaseController;
import com.wechat.dao.*;
import com.wechat.entity.*;
import com.wechat.exception.BizExceptionEnum;
import com.wechat.exception.BussinessException;
import com.wechat.mapper.HomeworkMapper;
import com.wechat.mapper.StudentMapper;
import com.wechat.mapper.TeacherMapper;
import com.wechat.model.CommonResult;
import com.wechat.service.StudentService;
import com.wechat.util.JSONUtils;
import io.goeasy.GoEasy;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Wrapper;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController extends BaseController{

    @Autowired
    private NoticeBulletinDao noticeDao;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private HomeworkDao homeworkDao;

    @Autowired
    private ExamResultDao examResultDao;
    @Autowired
    private GoEasy goEasy;

    @Autowired
    private HomeworkMapper homeworkMapper;

    @Autowired
    private LeaveRecordDao leaveRecordDao;

    @ApiOperation(value = "获取单个学生信息接口",notes = "",produces = "application/json")
    @ApiImplicitParam(paramType = "path",name = "id",
                    value = "学生的主键id",
                    required = true, dataType = "Integer")
    @GetMapping(value = "/getStuInfo/{id}",produces = "application/json;charset=utf-8")
    public CommonResult<Student> getOneStudentInfo(@PathVariable Integer id){

        if (id.equals(null) || id.equals("")){
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        Student student = studentService.getStudentInfo(id);
        if (student!=null)
            return new CommonResult<Student>(successcode,student);
        throw new BussinessException(BizExceptionEnum.FAIL);
    }

    /**
     * 根据班级id查询当天作业
     * @param classId
     * @return
     */
    @GetMapping("/getHomeworkByClassId/{classId}")
    public CommonResult getHomeworkByClassId(HttpServletRequest request,@PathVariable(required = false) Integer classId){
        Student student = (Student) request.getSession().getAttribute("user");

        if (classId != null){
            List<Map<String,Object>> homeworks= homeworkDao.getNowDateHomeworkByClassId(classId);
            return new CommonResult(successcode,homeworks);
        }
        classId = student.getClaId();
        List<Map<String,Object>> homeworks= homeworkDao.getNowDateHomeworkByClassId(classId);

        goEasy.publish("getHomeworkByClassIdStudent", JSONUtils.toJson(new CommonResult(successcode,homeworks,student.getId())));


        return new CommonResult(successcode,homeworks);
    }

    //根据时间查询作业
    @GetMapping("/getHomeworkByTime/{classId}")
    public CommonResult getHomeworkByClassId(HttpServletRequest request,String date,@PathVariable(required = false) Integer classId){
        Student student = (Student) request.getSession().getAttribute("user");
        Homework homework = new Homework();
        List<Homework> homeworks= homework.selectList("cla_id = {0} and date_format(create_time,\"%Y-%m-%d\") = {1}",classId,date);

        goEasy.publish("getHomeworkByTimeStudent", JSONUtils.toJson(new CommonResult(successcode,homeworks,student.getId())));


        return new CommonResult(successcode,homeworks);
    }


    /**
     * 根据作业id查询作业详情
     * @return
     */
    @GetMapping("/getOneHomeworkById/{homeworkId}")
    public CommonResult getOneHomeworkById(@PathVariable(required = true) Integer homeworkId){
        Homework homework = homeworkDao.selectByPrimaryKey(homeworkId);
        if (homework == null){
            return new CommonResult(errorcode,errorMessage);
        }
        return new CommonResult(successcode,homework);
    }

    /**
     * 单个学生成绩
     * @param stuId
     * @return
     */
    @GetMapping("/getOneStudentScore/{stuId}")
    public CommonResult getOneStudentScore(@PathVariable(required = true) Integer stuId){
        List<Map<String, Object>> list = examResultDao.selectByStuId(stuId);
        if (list.isEmpty()){
            return new CommonResult(errorcode,errorMessage);
        }
        return new CommonResult(successcode,list);
    }

    /**
     * 查询单个学生某个日期范围内的成绩
     * @param stuId
     * @param startTime
     * @param endTime
     * @param term
     * @return
     */
    @RequestMapping(value = "/getOneStudentByTimeArange")
    public CommonResult getOneStudentByTimeArange(@RequestParam("stuId") Integer stuId,
                                                  @RequestParam("startTime") String startTime,
                                                  @RequestParam("endTime") String endTime,
                                                  @RequestParam("term") Integer term){
        List<Map<String, Object>> list = examResultDao.getOneStudentByTimeArange(stuId,startTime,endTime,term);

        if (list.isEmpty())
            return new CommonResult(errorcode,errorMessage);
        return  new CommonResult(successcode,list);
    }

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("/student");
        Student student = (Student)request.getSession().getAttribute("user");
        Classes classes = new Classes();
        classes = classes.selectById(student.getClaId());
        //添加班级信息
        modelAndView.addObject("classes",classes);
        Teacher headMaster = new Teacher();
        headMaster = headMaster.selectById(classes.getTeacher());
        //添加班主任信息
        modelAndView.addObject("headMaster",headMaster);


        return modelAndView;
    }

    @RequestMapping("/getLeaveRecord")
    public TableResult getLeaveRecord(HttpServletRequest request, int stuId, @RequestParam(required = false) String date,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int limit){
        Page<Map<String,Object>> mapPage = studentService.getLeaveRecord(stuId,date,page,limit);
        TableResult<Object> result = new TableResult<>();

        result.setCode(0);
        result.setCount((int)mapPage.getTotal());
        result.setData(mapPage);
        return result;
    }

    @RequestMapping("/getNotice")
    public TableResult getNotice(int id){
        Map<String,Object> map = noticeDao.getNotice(id);

        TableResult<Object> result = new TableResult<>();
        if(map != null){
            result.setData(map);
            result.setCode(0);

        }else{
            result.setCode(-1);
            result.setMsg("没有找到该通知");
        }
        return result;
    }


}
