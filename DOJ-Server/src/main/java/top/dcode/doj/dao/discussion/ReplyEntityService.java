package top.dcode.doj.dao.discussion;

import com.baomidou.mybatisplus.extension.service.IService;
import top.dcode.doj.pojo.entity.discussion.Reply;
import top.dcode.doj.pojo.vo.ReplyVO;

import java.util.List;

/**

 */
public interface ReplyEntityService extends IService<Reply> {

    public List<ReplyVO> getAllReplyByCommentId(Long cid, String uid, Boolean isRoot, Integer commentId);

    public void updateReplyMsg(Integer sourceId, String sourceType, String content,
                               Integer quoteId, String quoteType, String recipientId,String senderId);
}