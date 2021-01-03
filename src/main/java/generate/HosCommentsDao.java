package generate;

import generate.HosComments;

public interface HosCommentsDao {
    int deleteByPrimaryKey(Long commentId);

    int insert(HosComments record);

    int insertSelective(HosComments record);

    HosComments selectByPrimaryKey(Long commentId);

    int updateByPrimaryKeySelective(HosComments record);

    int updateByPrimaryKey(HosComments record);
}