package top.dcode.doj.dao.user;

import com.baomidou.mybatisplus.extension.service.IService;
import top.dcode.doj.pojo.dto.RegisterDTO;
import top.dcode.doj.pojo.entity.user.UserInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface UserInfoEntityService extends IService<UserInfo> {

    public Boolean addUser(RegisterDTO registerDto);

    public List<String> getSuperAdminUidList();

    public List<String> getProblemAdminUidList();
}
