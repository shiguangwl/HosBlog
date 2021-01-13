package com.xxhoz.service;

import com.xxhoz.pojo.HosUser;

public interface HosUsersService {
    int deleteByPrimaryKey(Long userId);

    int insert(HosUser record);

    int insertSelective(HosUser record);

    HosUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(HosUser record);

    int updateByPrimaryKey(HosUser record);

    HosUser queryUser(String username,String password);
}
