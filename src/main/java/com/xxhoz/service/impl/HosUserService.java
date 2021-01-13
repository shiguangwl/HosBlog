package com.xxhoz.service.impl;

import com.xxhoz.dao.HosUsersDao;
import com.xxhoz.pojo.HosUser;

import com.xxhoz.service.HosUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HosUserService implements HosUsersService {

    @Autowired
    HosUsersDao hosUsersDao;

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return 0;
    }

    @Override
    public int insert(HosUser record) {
        return 0;
    }

    @Override
    public int insertSelective(HosUser record) {
        return 0;
    }

    @Override
    public HosUser selectByPrimaryKey(Long userId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(HosUser record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(HosUser record) {
        return 0;
    }

    @Override
    public HosUser queryUser(String username, String password) {
        HosUser hosUser = new HosUser(null, username, password, null, null, null, null);
        return hosUsersDao.queryUser(hosUser);
    }


}
