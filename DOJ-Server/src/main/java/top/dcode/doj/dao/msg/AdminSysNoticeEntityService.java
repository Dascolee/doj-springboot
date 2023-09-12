package top.dcode.doj.dao.msg;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import top.dcode.doj.pojo.entity.msg.AdminSysNotice;
import top.dcode.doj.pojo.vo.AdminSysNoticeVO;


/**
 */
public interface AdminSysNoticeEntityService extends IService<AdminSysNotice> {

    public IPage<AdminSysNoticeVO> getSysNotice(int limit, int currentPage, String type);

}