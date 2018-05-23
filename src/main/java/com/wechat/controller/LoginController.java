package com.wechat.controller;


import com.wechat.common.constat.tips.ErrorTip;
import com.wechat.common.controller.BaseController;
import com.wechat.entity.Student;
import com.wechat.entity.Teacher;
import com.wechat.exception.BizExceptionEnum;
import com.wechat.exception.BussinessException;
import com.wechat.model.CommonResult;
import com.wechat.service.StudentService;
import com.wechat.service.TeacherService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController  extends BaseController{


    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "三端登陆接口",notes = "",produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path",name = "identity",
                    value = "用户需要提供的的登陆身份，作为请求路径的一部分分别是：student,teacher,parent",
                    required = true, dataType = "String"),
            @ApiImplicitParam(name = "account", value = "登陆需要提供的账号", required = true, dataType = "account"),
            @ApiImplicitParam(name = "password", value = "登陆需要的凭证（密码或学生身份证号）", required = true, dataType = "password")
    })
    @RequestMapping(value = "/{identity}/login",method = RequestMethod.POST,
    produces = "application/json;charset=utf-8")
    public CommonResult<?> login(@PathVariable("identity") String identity,
                                       @RequestParam("account") String account,
                                       @RequestParam("password") String password) throws IllegalAccessException, ClassNotFoundException {
        Map<String,?> responseBody = new HashMap<String,Object>();
        if (identity.equals("teacher")){
            Teacher teacher = new Teacher();
            teacher.setTeacherId(account);
            teacher.setPassword(password);
            responseBody = teacherService.CheckLoginTeacher(teacher.getTeacherId(),teacher.getPassword());
        }else if (identity.equals("student")){
            Student student = new Student();
            student.setStudentNumber(account);
            student.setPassword(password);
            responseBody = studentService.CheckLoginStudent(student.getStudentNumber(),student.getPassword());
        }else if (identity.equals("parent")){
            Student student = new Student();
            student.setStudentNumber(account);
            student.setIdentityNumber(password);
            responseBody = studentService.CheckLoginParent(student.getStudentNumber(),student.getIdentityNumber());
        }
        if (responseBody instanceof Object)
            return new CommonResult<Object>(0, responseBody);
        return new CommonResult<>(errorcode,errorMessage);
    }
}
