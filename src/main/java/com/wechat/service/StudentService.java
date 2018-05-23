package com.wechat.service;

import com.wechat.bean.MyClass;
import com.wechat.entity.ExamResult;
import com.wechat.entity.Homework;
import com.wechat.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @时间: 2018/4/16
 * @描述：提供有关学生的一些数据
 */

public interface StudentService {

    Student isStudent(Student student);
    //根据id获取学生信息
    Student getStudentInfo(Integer sId);
    //根据学生信息获取学生当天各科作业列表
    List<Homework> getTodayHomeWork(Student student);
    //获取学生成绩
    List<ExamResult> getScoreBySid(Student student);
    //获取班级信息

    MyClass getClassByCid(Student student);


    Map<String,Object> CheckLoginStudent(String studentNumber, String password) throws IllegalAccessException;

    Map<String,Object> CheckLoginParent(String studentNumber, String identityNumber);
}
