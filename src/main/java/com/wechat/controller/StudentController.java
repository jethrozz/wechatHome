package com.wechat.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wechat.common.controller.BaseController;
import com.wechat.dao.StudentDao;
import com.wechat.dao.TeacherDao;
import com.wechat.entity.Student;
import com.wechat.entity.Teacher;
import com.wechat.exception.BizExceptionEnum;
import com.wechat.exception.BussinessException;
import com.wechat.mapper.StudentMapper;
import com.wechat.mapper.TeacherMapper;
import com.wechat.model.CommonResult;
import com.wechat.service.StudentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;

@RestController
@RequestMapping("/student")
public class StudentController extends BaseController{






    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDao studentDao;

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

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        //EntityWrapper<Teacher> ew = new EntityWrapper<>();
        //ew.where("",).and("","").or("",)
        return studentDao.selectByPrimaryKey(1).getName();
    }
}
