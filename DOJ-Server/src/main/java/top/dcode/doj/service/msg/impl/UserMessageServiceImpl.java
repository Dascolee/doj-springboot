package top.dcode.doj.service.msg.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.dcode.doj.common.exception.StatusFailException;
import top.dcode.doj.common.result.CommonResult;
import top.dcode.doj.manager.msg.UserMessageManager;
import top.dcode.doj.pojo.vo.UserMsgVO;
import top.dcode.doj.pojo.vo.UserUnreadMsgCountVO;
import top.dcode.doj.service.msg.UserMessageService;

import javax.annotation.Resource;

/**
 */
@Service
public class UserMessageServiceImpl implements UserMessageService {

    @Resource
    private UserMessageManager userMessageManager;

    @Override
    public CommonResult<UserUnreadMsgCountVO> getUnreadMsgCount() {
        return CommonResult.successResponse(userMessageManager.getUnreadMsgCount());
    }

    @Override
    public CommonResult<Void> cleanMsg(String type, Long id) {
        try {
            userMessageManager.cleanMsg(type, id);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<IPage<UserMsgVO>> getCommentMsg(Integer limit, Integer currentPage) {
        return CommonResult.successResponse(userMessageManager.getCommentMsg(limit, currentPage));
    }
    @Transactional
    @Override
    public CommonResult<IPage<UserMsgVO>> getReplyMsg(Integer limit, Integer currentPage) {
        return CommonResult.successResponse(userMessageManager.getReplyMsg(limit, currentPage));
    }

    @Override
    public CommonResult<IPage<UserMsgVO>> getLikeMsg(Integer limit, Integer currentPage) {
        return CommonResult.successResponse(userMessageManager.getLikeMsg(limit, currentPage));
    }
}