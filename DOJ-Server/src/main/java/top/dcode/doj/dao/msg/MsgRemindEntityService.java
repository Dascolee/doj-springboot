package top.dcode.doj.dao.msg;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import top.dcode.doj.pojo.entity.msg.MsgRemind;
import top.dcode.doj.pojo.vo.UserMsgVO;
import top.dcode.doj.pojo.vo.UserUnreadMsgCountVO;


/**
 */
public interface MsgRemindEntityService extends IService<MsgRemind> {

    UserUnreadMsgCountVO getUserUnreadMsgCount(String uid);

    IPage<UserMsgVO> getUserMsg(Page<UserMsgVO> page, String uid, String action);
}