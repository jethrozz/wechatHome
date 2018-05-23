package com.wechat.dao;

import com.wechat.entity.TeacherClass;
import com.wechat.entity.TeacherClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherClassDao {
    int countByExample(TeacherClassExample example);

    int deleteByExample(TeacherClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeacherClass record);

    int insertSelective(TeacherClass record);

    List<TeacherClass> selectByExample(TeacherClassExample example);

    TeacherClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeacherClass record, @Param("example") TeacherClassExample example);

    int updateByExample(@Param("record") TeacherClass record, @Param("example") TeacherClassExample example);

    int updateByPrimaryKeySelective(TeacherClass record);

    int updateByPrimaryKey(TeacherClass record);
}