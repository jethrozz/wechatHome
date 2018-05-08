package com.wechat.dao;

import com.wechat.entity.StudentParent;
import com.wechat.entity.StudentParentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentParentMapper {
    int countByExample(StudentParentExample example);

    int deleteByExample(StudentParentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentParent record);

    int insertSelective(StudentParent record);

    List<StudentParent> selectByExample(StudentParentExample example);

    StudentParent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentParent record, @Param("example") StudentParentExample example);

    int updateByExample(@Param("record") StudentParent record, @Param("example") StudentParentExample example);

    int updateByPrimaryKeySelective(StudentParent record);

    int updateByPrimaryKey(StudentParent record);
}