package com.wechat.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wechat.common.controller.BaseController;
import com.wechat.dao.ExamResultDao;
import com.wechat.dao.HomeworkDao;
import com.wechat.dao.StudentDao;
import com.wechat.dao.TeacherDao;
import com.wechat.entity.ExamResult;
import com.wechat.entity.Homework;
import com.wechat.entity.Student;
import com.wechat.entity.Teacher;
import com.wechat.exception.BizExceptionEnum;
import com.wechat.exception.BussinessException;
import com.wechat.mapper.HomeworkMapper;
import com.wechat.mapper.StudentMapper;
import com.wechat.mapper.TeacherMapper;
import com.wechat.model.CommonResult;
import com.wechat.service.StudentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController extends BaseController{

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private HomeworkDao homeworkDao;

    @Autowired
    private ExamResultDao examResultDao;

    @Autowired
    private HomeworkMapper homeworkMapper;

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
    public CommonResult getHomeworkByClassId(@PathVariable(required = false) Integer classId){
        if (classId != null){
            List<Map<String,Object>> homeworks= homeworkDao.getNowDateHomeworkByClassId(classId);
            return new CommonResult(successcode,homeworks);
        }
        Student student = (Student)request.getSession().getAttribute("user");
        classId = student.getClaId();
        List<Map<String,Object>> homeworks= homeworkDao.getNowDateHomeworkByClassId(classId);
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

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        //EntityWrapper<Teacher> ew = new EntityWrapper<>();
        //ew.where("",).and("","").or("",)
        return studentDao.selectByPrimaryKey(1).getName();
    }


}
