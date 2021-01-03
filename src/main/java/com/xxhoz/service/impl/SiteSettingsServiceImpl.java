package com.xxhoz.service.impl;

import com.xxhoz.dao.ArticlesDao;
import com.xxhoz.dao.SiteSettingsDao;
import com.xxhoz.dao.UserOptionDao;
import com.xxhoz.pojo.HosOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteSettingsServiceImpl implements com.xxhoz.service.SiteSettingsService {

    @Autowired
    SiteSettingsDao siteSettingsDao;

    public List<HosOption> querySettings() {
        return siteSettingsDao.querySettings();
    }

    public int updataSettings(List<HosOption> hosOptions) {
        return siteSettingsDao.updataSettings(hosOptions);
    }
}
