package com.xxhoz.service;

import com.xxhoz.pojo.HosUser;

import java.util.List;

public interface UserOptionService {
    /*添加用户*/
    int addUser(HosUser hosUser);
    /*删除用户*/
    int deleteUserById(int userId);
    /*修改用户*/
    int updataUser(HosUser hosUser);
    /*查询用户*/
    List<HosUser> queryAllUser();
}
