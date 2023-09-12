package top.dcode.doj.controller.oj;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.dcode.doj.common.result.CommonResult;
import top.dcode.doj.pojo.vo.UserMsgVO;
import top.dcode.doj.pojo.vo.UserUnreadMsgCountVO;
import top.dcode.doj.service.msg.UserMessageService;

import javax.annotation.Resource;


/**
 * @Description: 获取用户 评论我的、回复我的、收到的赞的消息
 */
@RestController
@RequestMapping("/api/msg")
public class UserMessageController {

    @Resource
    private UserMessageService userMessageService;

    /**
     * @MethodName getUnreadMsgCount
     * @Description 获取用户的未读消息数量，包括评论我的、回复我的、收到的赞、系统通知、我的消息
     * @Return
     */
    @RequestMapping(value = "/unread", method = RequestMethod.GET)
    @RequiresAuthentication
    public CommonResult<UserUnreadMsgCountVO> getUnreadMsgCount() {
        CommonResult<UserUnreadMsgCountVO> res = userMessageService.getUnreadMsgCount();
        return res;
    }

    /**
     * @param type Discuss Reply Like Sys Mine
     * @MethodName cleanMsg
     * @Description 根据type，清空各个消息模块的消息或单个消息
     * @Return
     */
    @RequestMapping(value = "/clean", method = RequestMethod.DELETE)
    @RequiresAuthentication
    public CommonResult<Void> cleanMsg(@RequestParam("type") String type,
                                       @RequestParam(value = "id", required = false) Long id) {
        return userMessageService.cleanMsg(type, id);
    }


    /**
     * @param limit
     * @param currentPage
     * @MethodName getCommentMsg
     * @Description 获取评论我的讨论贴的消息，按未读的在前、时间晚的在前进行排序
     * @Return
     */
    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    @RequiresAuthentication
    public CommonResult<IPage<UserMsgVO>> getCommentMsg(@RequestParam(value = "limit", required = false) Integer limit,
                                                        @RequestParam(value = "currentPage", required = false) Integer currentPage) {
        return userMessageService.getCommentMsg(limit, currentPage);
    }

    /**
     * @param limit
     * @param currentPage
     * @MethodName getReplyMsg
     * @Description 获取回复我的评论的消息，按未读的在前、时间晚的在前进行排序
     * @Return
     */
    @RequestMapping(value = "/reply", method = RequestMethod.GET)
    @RequiresAuthentication
    public CommonResult<IPage<UserMsgVO>> getReplyMsg(@RequestParam(value = "limit", required = false) Integer limit,
                                                      @RequestParam(value = "currentPage", required = false) Integer currentPage) {
        return userMessageService.getReplyMsg(limit, currentPage);
    }


    /**
     * @param limit
     * @param currentPage
     * @MethodName getLikeMsg
     * @Description 获取点赞我的的消息，按未读的在前、时间晚的在前进行排序
     * @Return
     */
    @RequestMapping(value = "/like", method = RequestMethod.GET)
    @RequiresAuthentication
    public CommonResult<IPage<UserMsgVO>> getLikeMsg(@RequestParam(value = "limit", required = false) Integer limit,
                                                     @RequestParam(value = "currentPage", required = false) Integer currentPage) {
        return userMessageService.getLikeMsg(limit, currentPage);
    }

}