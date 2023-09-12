package top.dcode.doj.service.msg;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.dcode.doj.common.result.CommonResult;
import top.dcode.doj.pojo.vo.UserMsgVO;
import top.dcode.doj.pojo.vo.UserUnreadMsgCountVO;

public interface UserMessageService {

    public CommonResult<UserUnreadMsgCountVO> getUnreadMsgCount();

    public CommonResult<Void> cleanMsg(String type, Long id);

    public CommonResult<IPage<UserMsgVO>> getCommentMsg(Integer limit, Integer currentPage);

    public CommonResult<IPage<UserMsgVO>> getReplyMsg(Integer limit, Integer currentPage);

    public CommonResult<IPage<UserMsgVO>> getLikeMsg(Integer limit, Integer currentPage);

}
