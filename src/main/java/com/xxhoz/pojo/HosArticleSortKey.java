package com.xxhoz.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * hos_article_sort
 * @author
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HosArticleSortKey implements Serializable {
    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 分类ID
     */
    private Long sortId;

}
