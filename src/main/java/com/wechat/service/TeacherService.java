package com.wechat.service;

import com.wechat.entity.Classes;
import com.wechat.entity.Student;
import com.wechat.entity.Teacher;

import java.util.List;
import java.util.Map;

/**
 * @时间: 2018/4/16
 * @描述：
 */
public interface TeacherService {
    List<Student> getStudentByCid(Integer cid);
    Teacher isTeacher(Teacher teacher);
    Classes getClassByTeacherId(Teacher teacher);
    Map<String,Object> CheckLoginTeacher(String teacherId, String password);
}
