package com.xxhoz.controller;


import com.xxhoz.Utils.ResJsonUtils;
import com.xxhoz.pojo.HosArticles;
import com.xxhoz.pojo.HosOption;
import com.xxhoz.service.ArticlesService;
import com.xxhoz.service.impl.SiteSettingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/admin")
public class AdminControer {
    @Autowired
    ArticlesService articlesService;
    @Autowired
    SiteSettingsServiceImpl siteSettingsServiceImpl;


    @RequestMapping(value = "/updataArticle",method = RequestMethod.POST)
    public String updataArticle(@RequestBody HosArticles hosArticle) throws Exception{
        int i = articlesService.updateArticle(hosArticle);
        return ResJsonUtils.Tojson("修改成功");
    }

    @RequestMapping(value = "/addArticle",method = RequestMethod.POST)
    public String addArticle(@RequestBody HosArticles hosArticle) throws Exception{
        int i = articlesService.addArticle(hosArticle);
        return ResJsonUtils.Tojson("添加成功");
    }

    @RequestMapping(value = "/delArticle",method = RequestMethod.POST)
    public String addArticle(int articleId) throws Exception{
        int i = articlesService.deleteArticleById(articleId);
        return ResJsonUtils.Tojson("删除成功");
    }

    @RequestMapping(value = "/updateOption",method = RequestMethod.POST)
    public String updateOption(@RequestBody ArrayList<HosOption> hosOptions) throws Exception{
        System.out.println(hosOptions);
        int i = siteSettingsServiceImpl.updataSettings(hosOptions);
        return ResJsonUtils.Tojson("修改成功");
    }
}
