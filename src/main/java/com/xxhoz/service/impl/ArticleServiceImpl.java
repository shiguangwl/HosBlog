package com.xxhoz.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xxhoz.Utils.ResJsonUtils;
import com.xxhoz.dao.*;
import com.xxhoz.pojo.*;
import com.xxhoz.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;


@Service
public class ArticleServiceImpl implements ArticlesService {

    @Autowired
    ArticlesDao articlesDao;
    @Autowired
    HosArticleLableDao hosArticleLableDao;
    @Autowired
    HosArticleSortDao hosArticleSortDao;

    public int addSort(HosSort hosSort) {
        return articlesDao.addSort(hosSort);
    }

    public int deleteSortById(int id) {
        return articlesDao.deleteSortById(id);
    }

    public List<HosSort> querySortByArticleId(int id) {
        return articlesDao.querySortByArticleId(id);
    }

    public HosSort querySortById(int sortId) {
        return articlesDao.querySortById(sortId);
    }

    public int updataSort(HosSort hosSort) {
        return articlesDao.updataSort(hosSort);
    }

    public List<HosSort> queryAllSort() {
        return articlesDao.queryAllSort();
    }

    public HosLable queryLableById(int lableId) {
        return articlesDao.queryLableById(lableId);
    }

    public int addLable(HosLable hosLable) {
        return articlesDao.addLable(hosLable);
    }

    public int deleteLableById(int id) {
        return articlesDao.deleteLableById(id);
    }

    public List<HosLable> queryAllLable() {
        return articlesDao.queryAllLable();
    }

    public HosLable queryLableIdByName(String lableName) {
        return articlesDao.queryLableIdByName(lableName);
    }

    public int updataLable(HosLable hosLable) {
        return articlesDao.updataLable(hosLable);
    }

    public List<HosLable> queryLableByArticleId(int id) {
        return articlesDao.queryLableByArticleId(id);
    }

    @Transactional   //开启事务支持
    public int addArticle(HosArticles hosArticle) throws RuntimeException{
        articlesDao.addArticle(hosArticle);
        int articleid = hosArticle.getArticleId();
        //hosArticle.setArticleId(articleid);
        this.updataLableAndSort(hosArticle);
        // 3.添加文章
        return articleid;
    }
    @Transactional
    public int deleteArticleById(int articleId) {
        hosArticleLableDao.deleteByPrimaryKey((long)articleId);
        hosArticleSortDao.deleteByPrimaryKey(articleId);
        return articlesDao.deleteArticleById(articleId);
    }

    // 公共代码:标签 分类 操作
    private boolean updataLableAndSort(HosArticles hosArticle) throws RuntimeException{
        long articleId = hosArticle.getArticleId();
        if(hosArticle.getArticleSortName()!=null){
            // 1.修改文章分类
            // 获取分类ID
            int sortId = hosArticle.getArticleSortName().getSortId();
            // 判断分类是否存在,否者抛出异常
            HosSort hosSort = querySortById(sortId);
            if(hosSort==null){
                throw new RuntimeException();
            }else {
                /*中间表操作*/
                // 删除关于文章的分类
                hosArticleSortDao.deleteByPrimaryKey((int)articleId);
                // 添加分类
                hosArticleSortDao.insert(new HosArticleSortKey(articleId,(long)sortId));
            }
        }else {
            hosArticleSortDao.deleteByPrimaryKey((int)articleId);
        }


        if(hosArticle.getArticleLables()!=null){
            // 2.修改文章标签
            //2.1 查询所有的标签
            List<HosLable> hosLables = articlesDao.queryAllLable();
            List<HosLable> articleLables = hosArticle.getArticleLables();
            // 删除所有文章标签
            hosArticleLableDao.deleteByPrimaryKey(articleId);
            for(HosLable item : articleLables){
                // 判断是否存在标签 如果不存在则创建
                boolean flag=false;
                for(HosLable itemble : hosLables ){
                    if(itemble.getLableName().equals(item.getLableName())){
                        flag=true;
                    }
                }
                if(!flag){
                    articlesDao.addLable(new HosLable(null,item.getLableName(),null,null));
                }
                // 获取标签名
                String lableName = item.getLableName();
                HosLable hosLable = queryLableIdByName(lableName);
                hosArticleLableDao.insert(new HosArticleLable(articleId,hosLable.getLableId()));
            }
        }else {
            hosArticleLableDao.deleteByPrimaryKey(articleId);
        }
        return true;
    }

    @Transactional
    public int updateArticle(HosArticles hosArticle) {
        int i = articlesDao.updateArticle(hosArticle);
        this.updataLableAndSort(hosArticle);
        return i;
    }

    public List<HosArticles> queryAllArticlesByID(Long articleId) {
        return articlesDao.queryAllArticles(articleId);
    }

    public List<HosArticles> queryArticlesByLableId(int lableId) {
        return articlesDao.queryArticlesByLableId(lableId);
    }

    public List<HosArticles> queryArticlesBySortId(int sortId) {
        return articlesDao.queryArticlesBySortId(sortId);
    }

    public List<HosArticles> searchArticlesByTitle(String articleTitle) {
        return articlesDao.searchArticlesByTitle(articleTitle);
    }

    public List<HosComments> queryCommentsByArticleId(int articleId) {
        return articlesDao.queryCommentsByArticleId(articleId);
    }

    public int addComment(HosComments hosComment) {
        return articlesDao.addComment(hosComment);
    }

    public int deleteComment(int commentId) {
        return articlesDao.deleteComment(commentId);
    }

    @Override
    public String uploadFile(CommonsMultipartFile file, HttpServletRequest request) throws RuntimeException, IOException {
        String uploadFileName = file.getOriginalFilename();
        //如果文件名为空，直接回到首页！
        if ("".equals(uploadFileName)){
            return "Erro";
        }
        uploadFileName=System.currentTimeMillis()+"_"+uploadFileName;
        //上传路径保存设置
        String respath = "/upload/";
        String path = request.getServletContext().getRealPath("/upload");
        //如果路径不存在，创建一个
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }

        InputStream is = file.getInputStream(); //文件输入流
        //OutputStream os = new FileOutputStream(new File(realPath,uploadFileName)); //文件输出流
        BufferedOutputStream os  = new BufferedOutputStream(new FileOutputStream(new File(realPath,uploadFileName)));
        //读取写出
        int len=0;
        byte[] buffer = new byte[1024];
        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
            os.flush();
        }
        os.close();
        is.close();
        return respath+uploadFileName;
    }
}
