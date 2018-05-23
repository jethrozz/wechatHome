package com.wechat.controller;


import com.wechat.common.controller.BaseController;
import com.wechat.entity.Classes;
import com.wechat.mapper.ClassesMapper;
import com.wechat.mapper.TeacherMapper;
import com.wechat.model.CommonResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@Transactional
public class TeacherController extends BaseController {


    @Autowired
    private ClassesMapper classesMapper;


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
    public CommonResult<Object> getClassesInfo(@PathVariable Integer id){



        return null;
    }
}
