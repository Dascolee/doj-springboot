package top.dcode.doj.dao.msg.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.dcode.doj.dao.msg.AdminSysNoticeEntityService;
import top.dcode.doj.mapper.AdminSysNoticeMapper;
import top.dcode.doj.pojo.entity.msg.AdminSysNotice;
import top.dcode.doj.pojo.vo.AdminSysNoticeVO;

import javax.annotation.Resource;

/**
 */
@Service
public class AdminSysNoticeEntityServiceImpl extends ServiceImpl<AdminSysNoticeMapper, AdminSysNotice> implements AdminSysNoticeEntityService {

    @Resource
    private AdminSysNoticeMapper adminSysNoticeMapper;

    @Override
    public IPage<AdminSysNoticeVO> getSysNotice(int limit, int currentPage, String type) {
        Page<AdminSysNoticeVO> page = new Page<>(currentPage, limit);
        return adminSysNoticeMapper.getAdminSysNotice(page, type);
    }
}