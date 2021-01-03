import com.fasterxml.jackson.core.JsonProcessingException;
import com.xxhoz.Utils.ResJsonUtils;
import com.xxhoz.dao.*;
import com.xxhoz.pojo.*;
import com.xxhoz.service.ArticlesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestClass {
    @Autowired
    ArticlesDao articlesDao;
    @Autowired
    SiteSettingsDao siteSettingsDao;
    @Autowired
    UserOptionDao userOptionDao;
    @Autowired
    HosArticleLableDao hosArticleLableDao;
    @Autowired
    HosArticleSortDao hosArticleSortDao;

    @Autowired
    ArticlesService articlesService;

    @Test
    public void T1() throws Exception {

        HosComments hosComments = new HosComments(null, "shiguang", "25133@qq.com", "leir", new Timestamp(System.currentTimeMillis()), 0, 0, 1);
        int i = articlesService.addComment(hosComments);

        //System.out.println(articlesService.queryCommentsByArticleId(1));
        //List<HosArticles> title = articlesService.searchArticlesByTitle("标题");
        ////List<HosArticles> title = articlesService.queryAllArticles();
        //System.out.println(title);
        //articlesService.deleteArticleById(25);


        //ArrayList<HosLable> hosLables = new ArrayList<HosLable>();
        //hosLables.add(new HosLable(null,"大数据技术",null,null));
        //hosLables.add(new HosLable(null,"标签1",null,null));
        //
        //HosArticles hosArticles = new HosArticles(25,1,"admin", "我是标题1", "我是内容",
        //                66, 0, new Timestamp(new Date().getTime()), 0, "mini",
        //                "密码222",
        //                new HosSort(2,null,null,null,null),
        //                hosLables);
        //
        //articlesService.updateArticle(hosArticles);

        //ArrayList<HosLable> articleLables = new ArrayList<HosLable>();
        //articleLables.add(new HosLable(null,"我是标签111",null,null));
        //articleLables.add(new HosLable(null,"我是标签222",null,null));
        //articleLables.add(new HosLable(null,"测试标签",null,null));
        //
        //List<HosLable> hosLables = articlesDao.queryAllLable();
        //
        //hosArticleLableDao.deleteByPrimaryKey(2L);
        //for(HosLable item : articleLables){
        //    // 判断是否存在标签 如果不存在则创建
        //    boolean flag=false;
        //    for(HosLable itemble : hosLables ){
        //        if(itemble.getLableName().equals(item.getLableName())){
        //            flag=true;
        //        }
        //    }
        //    if(!flag){
        //        articlesDao.addLable(new HosLable(null,item.getLableName(),null,null));
        //    }
        //    // 获取标签名
        //    String lableName = item.getLableName();
        //    HosLable hosLable = articlesService.queryLableIdByName(lableName);
        //    System.out.println(hosLable.getLableId());
        //    hosArticleLableDao.insert(new HosArticleLable(2L,hosLable.getLableId()));
        //}


        //hosArticleSortDao.deleteByPrimaryKey(3L);
        //// 添加分类
        //hosArticleSortDao.insert(new HosArticleSortKey(3L,4L));


        //articlesDao.addLable(new HosLable(null,"测试标签",null,null));

        //HosSort hosSort = articlesService.querySortById(1);
        //System.out.println(hosSort);
        /*查询文章*/
        //List<HosArticles> hosArticles = articlesDao.queryAllArticles();
        //System.out.println(hosArticles);
        //List<HosLable> hosLables = new ArrayList<HosLable>();
        //hosLables.add(new HosLable(1,null,null,null));
        //HosArticles hosArticles = new HosArticles(null,1,"admin", "我是标题1", "我是内容",
        //        66, 0, new Timestamp(new Date().getTime()), 0, "mini",
        //        "密码111",
        //        new HosSort(1,null,null,null,null),
        //        hosLables);
        //System.out.println(ResJsonUtils.Tojson(hosArticles));

        //try {
        //    articlesService.addArticle(hosArticles);
        //}catch (Exception e){
        //    System.out.println("出现异常了");
        //}
        //articlesDao.updateArticle(hosArticles);
        //articlesDao.deleteArticleById(3);
    }

    @Test
    public void T2(){
        List<HosOption> hosOptions = siteSettingsDao.querySettings();
        System.out.println(hosOptions);
    }

    @Test
    public void T3(){
        List<HosOption> hosOptions = siteSettingsDao.querySettings();
        System.out.println(hosOptions);
    }
}
