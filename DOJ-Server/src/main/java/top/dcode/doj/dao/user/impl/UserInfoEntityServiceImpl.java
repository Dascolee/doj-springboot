package top.dcode.doj.dao.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dcode.doj.dao.user.UserInfoEntityService;
import top.dcode.doj.mapper.UserInfoMapper;
import top.dcode.doj.pojo.dto.RegisterDTO;
import top.dcode.doj.pojo.entity.user.UserInfo;
import top.dcode.doj.utils.Constants;
import top.dcode.doj.utils.RedisUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 */
@Service
public class UserInfoEntityServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoEntityService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Boolean addUser(RegisterDTO registerDto) {
        return userInfoMapper.addUser(registerDto) == 1;
    }

    @Override
    public List<String> getSuperAdminUidList() {

        String cacheKey = Constants.Account.SUPER_ADMIN_UID_LIST_CACHE.getCode();
        List<String> superAdminUidList = (List<String>) redisUtils.get(cacheKey);
        if (superAdminUidList == null) {
            superAdminUidList = userInfoMapper.getSuperAdminUidList();
            redisUtils.set(cacheKey, superAdminUidList, 12 * 3600);
        }
        return superAdminUidList;
    }

    @Override
    public List<String> getProblemAdminUidList() {
        return userInfoMapper.getProblemAdminUidList();
    }

}
