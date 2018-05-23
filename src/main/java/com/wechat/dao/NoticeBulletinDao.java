package com.wechat.dao;

import com.wechat.entity.NoticeBulletin;
import com.wechat.entity.NoticeBulletinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticeBulletinDao {
    int countByExample(NoticeBulletinExample example);

    int deleteByExample(NoticeBulletinExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NoticeBulletin record);

    int insertSelective(NoticeBulletin record);

    List<NoticeBulletin> selectByExampleWithBLOBs(NoticeBulletinExample example);

    List<NoticeBulletin> selectByExample(NoticeBulletinExample example);

    NoticeBulletin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NoticeBulletin record, @Param("example") NoticeBulletinExample example);

    int updateByExampleWithBLOBs(@Param("record") NoticeBulletin record, @Param("example") NoticeBulletinExample example);

    int updateByExample(@Param("record") NoticeBulletin record, @Param("example") NoticeBulletinExample example);

    int updateByPrimaryKeySelective(NoticeBulletin record);

    int updateByPrimaryKeyWithBLOBs(NoticeBulletin record);

    int updateByPrimaryKey(NoticeBulletin record);
}