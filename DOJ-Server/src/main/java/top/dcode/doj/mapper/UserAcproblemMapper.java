package top.dcode.doj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.dcode.doj.pojo.entity.user.UserAcproblem;


/**
 * <p>
 *  Mapper 接口
 * </p>

 */
@Mapper
@Repository
public interface UserAcproblemMapper extends BaseMapper<UserAcproblem> {

}
