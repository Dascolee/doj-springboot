package top.dcode.doj.dao.msg;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import top.dcode.doj.pojo.entity.msg.UserSysNotice;
import top.dcode.doj.pojo.vo.SysMsgVO;

public interface UserSysNoticeEntityService extends IService<UserSysNotice> {

    IPage<SysMsgVO> getSysNotice(int limit, int currentPage, String uid);

    IPage<SysMsgVO> getMineNotice(int limit, int currentPage, String uid);
}