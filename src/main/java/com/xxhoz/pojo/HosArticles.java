package com.xxhoz.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;


/**
 * @Description  hos_articles: table
 * @Author  Sunk
 * @Date 2020-12-30
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HosArticles  implements Serializable {
	/** 博文ID */
	private Integer articleId;
	/** 发表用户ID*/
	private Integer userId;
	/** 用户名*/
	private String userName;
	/** 博文标题 */
	private String articleTitle;
	/** 博文内容 */
	private String articleContent;
	/** 浏览量 */
	private Integer articleViews;
	/** 评论数 */
	private Integer articleCommentCount;
	/** 发表时间 */
	private Timestamp articleDate;
	/** 点赞数 */
	private Integer articleLikeCount;
	/** 文章简述 */
	private String articleMiniCentent;
	/** 文章密码 */
	private String articlePassword;


	/*  文章分类 */
	private HosSort articleSortName;
	/*  文章标签 */
	private List<HosLable> articleLables;
}
