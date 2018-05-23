package com.wechat.dao;


import com.wechat.entity.LeaveRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeaveRecordDao {
    int countByExample(LeaveRecordExample example);

    int deleteByExample(LeaveRecordExample example);

    int deleteByPrimaryKey(Integer id);


}