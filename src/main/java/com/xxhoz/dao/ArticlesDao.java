package com.xxhoz.dao;

import com.xxhoz.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticlesDao {
    // 添加分类
    int addSort(HosSort hosSort);
    // 删除分类
    int deleteSortById(int id);
    // 根据文章ID查询分类
    List<HosSort> querySortByArticleId(int id);
    // 根据ID查询
    HosSort querySortById(int sortId);
    // 修改分类
    int updataSort(HosSort hosSort);
    // 查询全部的分类
    List<HosSort> queryAllSort();

    // 添加标签
    int addLable(HosLable hosLable);
    // 删除标签
    int deleteLableById(int id);
    // 查询标签
    List<HosLable> queryAllLable();
    //根据ID查询标签
    HosLable queryLableById(int lableId);
    //根据标签吗查询ID
    HosLable queryLableIdByName(@Param("lableName") String lableName);
    // 修改标签
    int updataLable(HosLable hosLable);
    //根据文章ID查询标签
    List<HosLable> queryLableByArticleId(int id);

    /*添加文章*/
    int addArticle(HosArticles hosArticle);
    /*删除文章*/
    int deleteArticleById(int articleId);
    /*修改文章*/
    int updateArticle(HosArticles hosArticle);
    // 查询全部文章
    List<HosArticles> queryAllArticles(@Param("articleId") Long articleId);
    // 根据标签ID查询文章
    List<HosArticles> queryArticlesByLableId(int lableId);
    // 根据分类ID查询文章
    List<HosArticles> queryArticlesBySortId(int sortId);
    // 标题搜索文章
    List<HosArticles> searchArticlesByTitle(@Param("articleTitle") String articleTitle);


    /*根据文章ID查询评论*/
    List<HosComments> queryCommentsByArticleId(int articleId);
    /*添加评论*/
    int addComment(HosComments hosComment);
    /*删除评论*/
    int deleteComment(int commentId);



}
