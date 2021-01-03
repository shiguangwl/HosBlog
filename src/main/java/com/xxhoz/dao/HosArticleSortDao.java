package com.xxhoz.dao;

import com.xxhoz.pojo.HosArticleSortKey;

public interface HosArticleSortDao {
    int deleteByPrimaryKey(long key);

    int insert(HosArticleSortKey record);

    int insertSelective(HosArticleSortKey record);
}
