package top.dcode.doj.dao.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import top.dcode.doj.pojo.entity.user.Role;
import top.dcode.doj.pojo.entity.user.UserRole;
import top.dcode.doj.pojo.vo.UserRolesVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>

 */
public interface UserRoleEntityService extends IService<UserRole> {

    UserRolesVO getUserRoles(String uid, String username);

    List<Role> getRolesByUid(String uid);

    IPage<UserRolesVO> getUserList(int limit, int currentPage, String keyword, Boolean onlyAdmin);

    void deleteCache(String uid, boolean isRemoveSession);

    String getAuthChangeContent(int oldType,int newType);
}
