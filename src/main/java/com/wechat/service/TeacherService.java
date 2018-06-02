package com.wechat.service;

import com.github.pagehelper.Page;
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
    Page<Map<String,Object>> getNotice(int pageNo,int pageSize);

    Teacher CheckLoginTeacher(String teacherId, String password);

    Page<Map<String,Object>> getExamResult(int teaId,int pageNo,int pageSize);
    Page<Map<String,Object>> getLeaverRecord(int teaId,int pageNo,int pageSize);
    Page<Map<String,Object>> getHomework(int teaId,int pageNo,int pageSize);

}
