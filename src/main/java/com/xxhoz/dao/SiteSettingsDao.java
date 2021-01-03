package com.xxhoz.dao;

import com.xxhoz.pojo.HosOption;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface SiteSettingsDao {
    /*查询配置*/
    List<HosOption> querySettings();
    /*修改配置*/
    int updataSettings(List<HosOption> hosOptions);
}
