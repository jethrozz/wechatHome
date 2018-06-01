package com.wechat.controller;


import com.wechat.bean.ParentLoginResult;
import com.wechat.bean.StudentLoginResult;
import com.wechat.common.constat.tips.ErrorTip;
import com.wechat.common.controller.BaseController;
import com.wechat.entity.Parent;
import com.wechat.entity.Student;
import com.wechat.entity.Teacher;
import com.wechat.exception.BizExceptionEnum;
import com.wechat.exception.BussinessException;
import com.wechat.model.CommonResult;
import com.wechat.service.ParentService;
import com.wechat.service.StudentService;
import com.wechat.service.TeacherService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController  extends BaseController{


    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;
    @Autowired
    private ParentService parentService;

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
    public CommonResult<?> login(HttpServletRequest request, @PathVariable("identity") String identity,
                                 @RequestParam("account") String account,
                                 @RequestParam("password") String password, @RequestParam("openId")String openId) throws IllegalAccessException, ClassNotFoundException {
        Map<String,?> responseBody = new HashMap<String,Object>();
        if (identity.equals("teacher")){
            Teacher teacher = new Teacher();
            teacher.setTeacherId(account);
            teacher.setPassword(password);
            responseBody = teacherService.CheckLoginTeacher(teacher.getTeacherId(),teacher.getPassword());

            saveUserTosession(request,responseBody);
            return new CommonResult<Object>(0, responseBody);
        }else if (identity.equals("student")){
            Student student = new Student();
            student.setStudentNumber(account);
            student.setPassword(password);
            responseBody = studentService.CheckLoginStudent(student.getStudentNumber(),student.getPassword());

            if(responseBody instanceof Student){
                StudentLoginResult result = new StudentLoginResult();
                Student user = (Student) responseBody;
                //判断他的openId是否为空，如果为空就将该openId更新到他的记录中去
                if(StringUtils.isEmpty(user.getOpenId())){
                    user.setOpenId(openId);
                    studentService.updateStudent(user);
                }
                //封装返回结果
                result.setStudent(user);
                //将用户存储到session中
                saveUserTosession(request,responseBody);
                return new CommonResult<Object>(0, result);
            }

        }else if (identity.equals("parent")){
            Student student = new Student();
            student.setStudentNumber(account);
            student.setIdentityNumber(password);
            responseBody = studentService.CheckLoginParent(student.getStudentNumber(),student.getIdentityNumber());

            if(responseBody instanceof Student){
                //因为openId是唯一的，所以在家长用户登录之后，
                // 会去判断该家长用户以前是否认证过，如果认证过就直接登录，
                // 没有认证，就先将该家长写入之后
                //登录逻辑其实就是一个认证，学生用户是教师直接上传到数据库中的，所以只用做更新操作
                Parent parent = parentService.getParentByOpenId(openId);
                if(parent == null){
                    parent.setOpenid(openId);
                    parent.setName(student.getName()+"的家长");
                    parent = parentService.addParent(parent);
                }

                ParentLoginResult result = new ParentLoginResult();

                result.setParent(parent);
                result.setStudent((Student) responseBody);
                //将用户存储到session中
                saveUserTosession(request,parent);
                return new CommonResult<Object>(0, result);
            }
        }

        return new CommonResult<>(errorcode,errorMessage);
    }

    private void saveUserTosession(HttpServletRequest request,Object object){
        HttpSession session = request.getSession();
        session.setAttribute("user",object);
    }
}
