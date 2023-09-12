package top.dcode.doj.dao.msg.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.dcode.doj.dao.msg.UserSysNoticeEntityService;
import top.dcode.doj.mapper.UserSysNoticeMapper;
import top.dcode.doj.pojo.entity.msg.UserSysNotice;
import top.dcode.doj.pojo.vo.SysMsgVO;

import javax.annotation.Resource;

/**
 */
@Service
public class UserSysNoticeEntityServiceImpl extends ServiceImpl<UserSysNoticeMapper, UserSysNotice> implements UserSysNoticeEntityService {

    @Resource
    private UserSysNoticeMapper userSysNoticeMapper;

    @Override
    public IPage<SysMsgVO> getSysNotice(int limit, int currentPage, String uid) {
        Page<SysMsgVO> page = new Page<>(currentPage, limit);
        return userSysNoticeMapper.getSysOrMineNotice(page, uid, "Sys");
    }

    @Override
    public IPage<SysMsgVO> getMineNotice(int limit, int currentPage, String uid) {
        Page<SysMsgVO> page = new Page<>(currentPage, limit);
        return userSysNoticeMapper.getSysOrMineNotice(page, uid, "Mine");
    }

}