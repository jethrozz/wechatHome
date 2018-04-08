package com.wechat.dao;

import com.wechat.entity.TeacherClassExample;
import com.wechat.entity.TeacherClassKey;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeacherClassMapper {
    long countByExample(TeacherClassExample example);

    int deleteByExample(TeacherClassExample example);

    int deleteByPrimaryKey(TeacherClassKey key);

    int insert(TeacherClassKey record);

    int insertSelective(TeacherClassKey record);

    List<TeacherClassKey> selectByExample(TeacherClassExample example);

    int updateByExampleSelective(@Param("record") TeacherClassKey record, @Param("example") TeacherClassExample example);

    int updateByExample(@Param("record") TeacherClassKey record, @Param("example") TeacherClassExample example);
}