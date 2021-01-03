package com.xxhoz.service.impl;

import com.xxhoz.dao.ArticlesDao;
import com.xxhoz.dao.SiteSettingsDao;
import com.xxhoz.dao.UserOptionDao;
import com.xxhoz.pojo.HosUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOptionServiceImpl implements com.xxhoz.service.UserOptionService {

    @Autowired
    UserOptionDao userOptionDao;

    public int addUser(HosUser hosUser) {
        return userOptionDao.addUser(hosUser);
    }

    public int deleteUserById(int userId) {
        return userOptionDao.deleteUserById(userId);
    }

    public int updataUser(HosUser hosUser) {
        return userOptionDao.updataUser(hosUser);
    }

    public List<HosUser> queryAllUser() {
        return userOptionDao.queryAllUser();
    }
}
