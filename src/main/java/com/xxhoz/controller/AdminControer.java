package com.xxhoz.controller;


import com.xxhoz.Utils.ResJsonUtils;
import com.xxhoz.pojo.HosArticles;
import com.xxhoz.pojo.HosLable;
import com.xxhoz.pojo.HosOption;
import com.xxhoz.pojo.HosSort;
import com.xxhoz.service.ArticlesService;
import com.xxhoz.service.impl.SiteSettingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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

    /*更新文章*/
    @RequestMapping(value = "/updataArticle",method = RequestMethod.POST)
    public String updataArticle(@RequestBody HosArticles hosArticle) throws Exception{
        int i = articlesService.updateArticle(hosArticle);
        return ResJsonUtils.Tojson("修改成功");
    }
    /*添加文章*/
    @RequestMapping(value = "/addArticle",method = RequestMethod.POST)
    public String addArticle(@RequestBody HosArticles hosArticle) throws Exception{
        int i = articlesService.addArticle(hosArticle);
        return ResJsonUtils.Tojson("添加成功");
    }
    /*删除文章*/
    @RequestMapping(value = "/delArticle",method = RequestMethod.POST)
    public String addArticle(int articleId) throws Exception{
        int i = articlesService.deleteArticleById(articleId);
        return ResJsonUtils.Tojson("删除成功");
    }
    /*更新网站设置*/
    @RequestMapping(value = "/updateOption",method = RequestMethod.POST)
    public String updateOption(@RequestBody ArrayList<HosOption> hosOptions) throws Exception{
        System.out.println(hosOptions);
        int i = siteSettingsServiceImpl.updataSettings(hosOptions);
        return ResJsonUtils.Tojson("修改成功");
    }
    /*标签增删改*/
    @RequestMapping(value = "/lableOption",method = RequestMethod.POST)
    public String lableOption(@RequestBody HosLable lable,String opt) throws Exception{
        if("delete".equals(opt)){
            articlesService.deleteLableById(lable.getLableId().intValue());
        }else if("add".equals(opt)){
            articlesService.addLable(lable);
        }else if("update".equals(opt)){
            articlesService.updataLable(lable);
        }else{
            return ResJsonUtils.Tojson(5,"参数错误",null);
        }
        return ResJsonUtils.Tojson("更新成功");
        //articlesService.
    }

    /*分类增删改*/
    @RequestMapping(value = "/sortOption",method = RequestMethod.POST)
    public String sortOption(@RequestBody HosSort sort, String opt) throws Exception{
        if("delete".equals(opt)){
            articlesService.deleteSortById(sort.getSortId().intValue());
        }else if("add".equals(opt)){
            articlesService.addSort(sort);
        }else if("update".equals(opt)){
            articlesService.updataSort(sort);
        }else{
            return ResJsonUtils.Tojson(5,"参数错误",null);
        }
        return ResJsonUtils.Tojson("更新成功");
        //articlesService.
    }

    /*上传文件*/
    @RequestMapping(value = "/upfile",method = RequestMethod.POST)
    public String Login(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        String res = articlesService.uploadFile(file, request);
        return ResJsonUtils.Tojson(res);
    }
}
