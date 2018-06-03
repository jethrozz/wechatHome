package com.wechat.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.github.pagehelper.Page;
import com.wechat.entity.Teacher;
import com.wechat.entity.TeacherExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TeacherDao {
    int countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByExample(TeacherExample example);

    Teacher selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

//    @Select("select * from teacher where teacher_id = #{teacherId}")
    Teacher selectByPrimaryteacherId(@Param("teacherId") String teacherId);

    Page<Map<String,Object>> selectNoticeByPage();

    List<Map<String,Object>> selectClassTeacher(@Param("claId")int claId);

}