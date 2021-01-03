package com.xxhoz.service;

import com.xxhoz.pojo.HosOption;

import java.util.List;

public interface SiteSettingsService {
    /*查询配置*/
    List<HosOption> querySettings();
    /*修改配置*/
    int updataSettings(List<HosOption> hosOptions);
}
