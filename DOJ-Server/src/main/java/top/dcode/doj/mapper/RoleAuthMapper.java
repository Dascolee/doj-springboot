package top.dcode.doj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.dcode.doj.pojo.entity.user.RoleAuth;
import top.dcode.doj.pojo.vo.RoleAuthsVO;


/**
 * <p>
 *  Mapper 接口
 * </p>
 */
@Mapper
@Repository
public interface RoleAuthMapper extends BaseMapper<RoleAuth> {
    RoleAuthsVO getRoleAuths(@Param("rid") long rid);
}
