package top.dcode.doj.dao.msg.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.dcode.doj.dao.msg.MsgRemindEntityService;
import top.dcode.doj.mapper.MsgRemindMapper;
import top.dcode.doj.pojo.entity.msg.MsgRemind;
import top.dcode.doj.pojo.vo.UserMsgVO;
import top.dcode.doj.pojo.vo.UserUnreadMsgCountVO;

import javax.annotation.Resource;


/**
 */
@Service
public class MsgRemindEntityServiceImpl extends ServiceImpl<MsgRemindMapper, MsgRemind> implements MsgRemindEntityService {

    @Resource
    private MsgRemindMapper msgRemindMapper;
    @Override
    public UserUnreadMsgCountVO getUserUnreadMsgCount(String uid) {
        return msgRemindMapper.getUserUnreadMsgCount(uid);
    }

    @Override
    public IPage<UserMsgVO> getUserMsg(Page<UserMsgVO> page, String uid, String action) {
        return msgRemindMapper.getUserMsg(page, uid, action);
    }

}