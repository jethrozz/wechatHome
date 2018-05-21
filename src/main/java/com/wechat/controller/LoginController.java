package com.wechat.controller;


import com.wechat.entity.Parent;
import com.wechat.entity.Student;
import com.wechat.entity.Teacher;
import com.wechat.service.StudentService;
import com.wechat.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {


    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "三端登陆接口",notes = "",produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path",name = "identity",
                    value = "用户需要提供的的登陆身份，作为请求路径的一部分",
                    required = true, dataType = "String"),
            @ApiImplicitParam(name = "account", value = "登陆需要提供的账号", required = true, dataType = "account"),
            @ApiImplicitParam(name = "password", value = "登陆需要的凭证（密码或学生身份证号）", required = true, dataType = "password")
    })
    @RequestMapping(value = "/{identity}/login",method = RequestMethod.POST,
    produces = "application/json;charset=utf-8")
    public ResponseEntity<Object> login(@PathVariable("identity") String identity,
                                        @RequestParam("account") String account,
                                        @RequestParam("password") String password){
        Object responseBody = new Object();
        if (identity.equals("teacher")){
            Teacher teacher = new Teacher();
            teacher.setTeacherId(account);
            teacher.setPassword(password);
            responseBody = teacherService.isTeacher(teacher);
        }else if (identity.equals("student")){
            Student student = new Student();
            student.setStudentNumber(account);
            student.setPassword(password);
            responseBody = studentService.isStudent(student);
        }else if (identity.equals("parent")){
            Student student = new Student();
            student.setStudentNumber(account);
            student.setIdentityNumber(password);
            responseBody = studentService.isStudent(student);
        }
        return new ResponseEntity(responseBody,HttpStatus.OK);
    }
}
