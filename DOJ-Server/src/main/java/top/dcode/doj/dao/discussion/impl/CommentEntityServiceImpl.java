package top.dcode.doj.dao.discussion.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import top.dcode.doj.dao.contest.ContestEntityService;
import top.dcode.doj.dao.discussion.CommentEntityService;
import top.dcode.doj.dao.discussion.DiscussionEntityService;
import top.dcode.doj.dao.group.GroupMemberEntityService;
import top.dcode.doj.dao.msg.MsgRemindEntityService;
import top.dcode.doj.dao.user.UserInfoEntityService;
import top.dcode.doj.mapper.CommentMapper;
import top.dcode.doj.pojo.entity.contest.Contest;
import top.dcode.doj.pojo.entity.discussion.Comment;
import top.dcode.doj.pojo.entity.discussion.Discussion;
import top.dcode.doj.pojo.entity.group.GroupMember;
import top.dcode.doj.pojo.entity.msg.MsgRemind;
import top.dcode.doj.pojo.vo.CommentVO;
import top.dcode.doj.utils.Constants;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 */
@Service
public class CommentEntityServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentEntityService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private DiscussionEntityService discussionEntityService;

    @Autowired
    private ContestEntityService contestEntityService;

    @Autowired
    private UserInfoEntityService userInfoEntityService;

    @Resource
    private MsgRemindEntityService msgRemindEntityService;

    @Autowired
    private GroupMemberEntityService groupMemberEntityService;

    @Override
    public IPage<CommentVO> getCommentList(int limit, int currentPage, Long cid, Integer did, Boolean isRoot, String uid) {
        //新建分页
        Page<CommentVO> page = new Page<>(currentPage, limit);

        if (cid != null) {
            Contest contest = contestEntityService.getById(cid);

            boolean onlyMineAndAdmin = contest.getStatus().equals(Constants.Contest.STATUS_RUNNING.getCode())
                    && !isRoot && !contest.getUid().equals(uid);
            if (onlyMineAndAdmin) { // 自己和比赛管理者评论可看

                List<String> myAndAdminUidList = userInfoEntityService.getSuperAdminUidList();
                myAndAdminUidList.add(uid);
                myAndAdminUidList.add(contest.getUid());
                Long gid = contest.getGid();
                if (gid != null) {
                    QueryWrapper<GroupMember> groupMemberQueryWrapper = new QueryWrapper<>();
                    groupMemberQueryWrapper.eq("gid", gid).eq("auth", 5);
                    List<GroupMember> groupAdminUidList = groupMemberEntityService.list(groupMemberQueryWrapper);

                    for (GroupMember groupMember : groupAdminUidList) {
                        myAndAdminUidList.add(groupMember.getUid());
                    }
                }
                return commentMapper.getCommentList(page, cid, did, true, myAndAdminUidList);
            }

        }
        return commentMapper.getCommentList(page, cid, did, false, null);
    }

    @Async
    @Override
    public void updateCommentMsg(String recipientId, String senderId, String content, Integer discussionId, Long gid) {

        if (content.length() > 200) {
            content = content.substring(0, 200) + "...";
        }

        MsgRemind msgRemind = new MsgRemind();
        msgRemind.setAction("Discuss")
                .setRecipientId(recipientId)
                .setSenderId(senderId)
                .setSourceContent(content)
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


    @Async
    @Override
    public void updateCommentLikeMsg(String recipientId, String senderId, Integer sourceId, String sourceType) {

        MsgRemind msgRemind = new MsgRemind();
        msgRemind.setAction("Like_Discuss")
                .setRecipientId(recipientId)
                .setSenderId(senderId)
                .setSourceId(sourceId)
                .setSourceType(sourceType);

        if (sourceType.equals("Discussion")) {

            Discussion discussion = discussionEntityService.getById(sourceId);
            if (discussion != null) {
                if (discussion.getGid() != null) {
                    msgRemind.setUrl("/group/" + discussion.getGid() + "/discussion-detail/" + sourceId);
                } else {
                    msgRemind.setUrl("/discussion-detail/" + sourceId);
                }
            }
        } else if (sourceType.equals("Contest")) {
            msgRemind.setUrl("/contest/" + sourceId + "/comment");
        }

        msgRemindEntityService.saveOrUpdate(msgRemind);
    }
}
