package com.xxhoz.dao;

import com.xxhoz.pojo.HosLable;
import com.xxhoz.pojo.HosUser;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;

public interface UserOptionDao {
    /*添加用户*/
    int addUser(HosUser hosUser);
    /*删除用户*/
    int deleteUserById(int userId);
    /*修改用户*/
    int updataUser(HosUser hosUser);
    /*查询用户*/
    List<HosUser> queryAllUser();
}
