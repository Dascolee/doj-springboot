package top.dcode.doj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.dcode.doj.pojo.dto.RegisterDTO;
import top.dcode.doj.pojo.entity.user.UserInfo;

import java.util.List;


@Mapper
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    int addUser(RegisterDTO registerDto);

    List<String> getSuperAdminUidList();

    List<String> getProblemAdminUidList();
}
