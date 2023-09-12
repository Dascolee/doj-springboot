package top.dcode.doj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.dcode.doj.pojo.entity.discussion.Reply;
import top.dcode.doj.pojo.vo.ReplyVO;

import java.util.List;

/**

 */

@Mapper
@Repository
public interface ReplyMapper extends BaseMapper<Reply> {

    public List<ReplyVO> getAllReplyByCommentId(@Param("commentId") Integer commentId,
                                                @Param("myAndAdminUidList") List<String> myAndAdminUidList);
}