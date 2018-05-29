package com.wechat.dao;

import com.wechat.entity.Student;
import com.wechat.entity.StudentExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;

public interface StudentDao {

    int countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    //@Select("select * from student where id = #{id}")
    Student selectByPrimaryKey(@Param("id") Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

//    @Select({"select * from student where student_number = #{studentNumber}"})
    Map<String,Object> selectByPrimaryStudentNumber(@Param("student_number") String studentNumber);

//    @Select({"select * from student where student_number = #{studentNumber}"})
//    Student selectByPrimaryStudentNumber(@Param("studentNumber") String studentNumber);

    List<Student> selectByStudentClassId(@Param("cla_id") Integer cla_id);
}