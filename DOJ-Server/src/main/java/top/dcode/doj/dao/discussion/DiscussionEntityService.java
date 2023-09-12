package top.dcode.doj.dao.discussion;

import com.baomidou.mybatisplus.extension.service.IService;
import top.dcode.doj.pojo.entity.discussion.Discussion;
import top.dcode.doj.pojo.vo.DiscussionVO;

public interface DiscussionEntityService extends IService<Discussion> {

    DiscussionVO getDiscussion(Integer did, String uid);

    void updatePostLikeMsg(String recipientId, String senderId, Integer discussionId, Long gid);
}
