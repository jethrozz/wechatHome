package com.wechat.service;

import com.github.pagehelper.Page;
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

    boolean updateStudent(Student student);

    Student isStudent(Student student);
    //根据id获取学生信息
    Student getStudentInfo(Integer sId);
    //根据学号获取学生
    Student getStudentInfoByStudentNumber(String studentNumber);
    //根据学生信息获取学生当天各科作业列表
    List<Homework> getTodayHomeWork(Student student);
    //获取学生成绩
    List<ExamResult> getScoreBySid(Student student);
    //获取班级信息

    MyClass getClassByCid(Student student);

    Student CheckLoginStudent(String studentNumber, String password);

    Student CheckLoginParent(String studentNumber, String identityNumber);

    Page<Map<String,Object>> getLeaveRecord(int stuId,String date,int pageNo,int pageSize);

}
