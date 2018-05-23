package com.wechat.dao;

import com.wechat.entity.ExamResult;
import com.wechat.entity.ExamResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamResultDao {
    int countByExample(ExamResultExample example);

    int deleteByExample(ExamResultExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExamResult record);

    int insertSelective(ExamResult record);

    List<ExamResult> selectByExample(ExamResultExample example);

    ExamResult selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExamResult record, @Param("example") ExamResultExample example);

    int updateByExample(@Param("record") ExamResult record, @Param("example") ExamResultExample example);

    int updateByPrimaryKeySelective(ExamResult record);

    int updateByPrimaryKey(ExamResult record);
}