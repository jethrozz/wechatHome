package com.wechat.bean;

import com.wechat.entity.Class;
import com.wechat.entity.Student;
import com.wechat.entity.Teacher;

import java.util.List;

/**
 * @时间: 2018/4/16
 * @描述：封装的要传入到前端的班级类，包括任课教师，班主任，班级信息，班上学生
 */
public class MyClass {

    private Class myclass;
    private Teacher headMaster;
    private List<Teacher> teacherList;
    private List<Student> studentList;

    public Class getMyclass() {
        return myclass;
    }

    public void setMyclass(Class myclass) {
        this.myclass = myclass;
    }

    public Teacher getHeadMaster() {
        return headMaster;
    }

    public void setHeadMaster(Teacher headMaster) {
        this.headMaster = headMaster;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
