package com.xxhoz.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * hos_article_lable
 * @author
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HosArticleLable implements Serializable {
    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 标签ID
     */
    private Long lableId;

}
