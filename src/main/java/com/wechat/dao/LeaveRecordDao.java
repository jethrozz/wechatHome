package com.wechat.dao;


import com.github.pagehelper.Page;
import com.wechat.entity.LeaveRecordExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface LeaveRecordDao {
    int countByExample(LeaveRecordExample example);

    int deleteByExample(LeaveRecordExample example);

    int deleteByPrimaryKey(Integer id);

    Page<Map<String,Object>> getTeacherLeaveList(@Param("teaId")int teaId);

    Page<Map<String,Object>> getStudentLeaveList(@Param("stuId")int stuId,@Param("date")String date);
}