package com.xxhoz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mysql.jdbc.StringUtils;
import com.xxhoz.Utils.ResJsonUtils;
import com.xxhoz.pojo.*;
import com.xxhoz.service.ArticlesService;
import com.xxhoz.service.impl.SiteSettingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/api/article")
@RestController
@ControllerAdvice
public class ArticleControer {

    @Autowired
    ArticlesService articlesService;
    @Autowired
    SiteSettingsServiceImpl siteSettingsServiceImpl;
    /*查询文章*/
    @RequestMapping("/queryArticle")
    public String GetArticle(Long articleId) throws JsonProcessingException {
        List<HosArticles> hosArticles = articlesService.queryAllArticlesByID(articleId);
        return ResJsonUtils.Tojson(hosArticles);
    }


    @RequestMapping("*")
     public String page404(){
        return "404";
     }
    @ExceptionHandler
    public String exceptionHandler(Exception e) throws JsonProcessingException {
        e.printStackTrace();
        return ResJsonUtils.Tojson(4,"Top Error",null);
    }
    /*搜索文章*/
    @RequestMapping("/searchArticle")
    public String GetSearchArticle(HttpServletRequest httpServletRequest) throws JsonProcessingException {
        if(httpServletRequest.getMethod().equals("POST")){
            String titleKw = httpServletRequest.getParameter("titleKw");
            if(StringUtils.isNullOrEmpty(titleKw)){
                return ResJsonUtils.Tojson(5,"请传递正确的关键词参数",null);
            }
            List<HosArticles> hosArticles = articlesService.searchArticlesByTitle(titleKw);
            return ResJsonUtils.Tojson(hosArticles);
        }else {
            return ResJsonUtils.Tojson(6,"请求异常",null);
        }

    }

    /*查询分类*/
    @RequestMapping("/querySort")
    public String GetSort() throws JsonProcessingException {
        List<HosSort> hosSorts = articlesService.queryAllSort();
        return ResJsonUtils.Tojson(hosSorts);
    }

    /*查询标签*/
    @RequestMapping("/queryLable")
    public String GetLable() throws JsonProcessingException {
        List<HosLable> hosLables = articlesService.queryAllLable();
        return ResJsonUtils.Tojson(hosLables);
    }

    /*查询文章评论*/
    @RequestMapping("/queryComment/{articleId}")
    public String GetComment(@PathVariable("articleId") String articleId) throws JsonProcessingException {
        int articleIdInt;
        try {
            articleIdInt = Integer.parseInt(articleId);
        }catch (Exception e){
            return ResJsonUtils.Tojson(4,"传参错误",null);
        }
        List<HosComments> hosComments = articlesService.queryCommentsByArticleId(articleIdInt);
        return ResJsonUtils.Tojson(hosComments);
    }

    /*添加评论*/
    @RequestMapping(value = "/addComment",method = RequestMethod.POST)
    public String addComment(@RequestBody HosComments hosComment) throws JsonProcessingException {
        hosComment.setCommentTime(new Timestamp(System.currentTimeMillis()));
        hosComment.setCommentLikeCount(0);
        hosComment.setCommentId(null);
        int i = articlesService.addComment(hosComment);
        if(i==1){
            return ResJsonUtils.Tojson("评论成功");
        }else {
            return ResJsonUtils.Tojson(4,"Erro",null);
        }
    }

    /*查询网站信息*/
    @RequestMapping(value = "/queryOption",method = RequestMethod.POST)
    public String queryOption() throws Exception{
        List<HosOption> hosOptions = siteSettingsServiceImpl.querySettings();
        return ResJsonUtils.Tojson(hosOptions);
    }


}
