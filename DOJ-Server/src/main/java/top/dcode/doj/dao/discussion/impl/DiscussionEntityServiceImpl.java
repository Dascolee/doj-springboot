package top.dcode.doj.dao.discussion.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import top.dcode.doj.dao.discussion.DiscussionEntityService;
import top.dcode.doj.dao.msg.MsgRemindEntityService;
import top.dcode.doj.mapper.DiscussionMapper;
import top.dcode.doj.pojo.entity.discussion.Discussion;
import top.dcode.doj.pojo.entity.msg.MsgRemind;
import top.dcode.doj.pojo.vo.DiscussionVO;

import javax.annotation.Resource;

/**
 */
@Service
public class DiscussionEntityServiceImpl extends ServiceImpl<DiscussionMapper, Discussion> implements DiscussionEntityService {

    @Autowired
    private DiscussionMapper discussionMapper;

    @Override
    public DiscussionVO getDiscussion(Integer did, String uid) {
        return discussionMapper.getDiscussion(did, uid);
    }

    @Resource
    private MsgRemindEntityService msgRemindEntityService;

    @Async
    public void updatePostLikeMsg(String recipientId, String senderId, Integer discussionId, Long gid) {

        MsgRemind msgRemind = new MsgRemind();
        msgRemind.setAction("Like_Post")
                .setRecipientId(recipientId)
                .setSenderId(senderId)
                .setSourceId(discussionId)
                .setSourceType("Discussion")
                .setUrl("/discussion-detail/" + discussionId);

        if (gid != null) {
            msgRemind.setUrl("/group/" + gid + "/discussion-detail/" + discussionId);
        } else {
            msgRemind.setUrl("/discussion-detail/" + discussionId);
        }

        msgRemindEntityService.saveOrUpdate(msgRemind);
    }
}