package generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * hos_comments
 * @author 
 */
@Data
public class HosComments implements Serializable {
    /**
     * 评论ID
     */
    private Long commentId;

    /**
     * 评论用户昵称
     */
    private String commentUserName;

    /**
     * 评论用户邮箱
     */
    private String commentEmail;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论时间
     */
    private Date commentTime;

    /**
     * 点赞数
     */
    private Long commentLikeCount;

    /**
     * 父评论ID
     */
    private Long parentCommentId;

    /**
     * 评论博文ID
     */
    private Long articleId;

    private static final long serialVersionUID = 1L;
}