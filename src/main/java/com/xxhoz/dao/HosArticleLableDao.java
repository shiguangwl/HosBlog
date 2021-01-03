package com.xxhoz.dao;

import com.xxhoz.pojo.HosArticleLable;
import org.apache.ibatis.annotations.Param;

import java.awt.*;

public interface HosArticleLableDao {
    int deleteByPrimaryKey(Long articleId);

    int insert(HosArticleLable record);

    int insertSelective(HosArticleLable record);

    HosArticleLable selectByPrimaryKey(Long articleId);

    int updateByPrimaryKeySelective(HosArticleLable record);

    int updateByPrimaryKey(HosArticleLable record);
}
