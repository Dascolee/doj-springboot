package top.dcode.doj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.dcode.doj.pojo.entity.problem.ProblemCount;

/**
 * Mapper 接口
 */
@Mapper
@Repository
public interface ProblemCountMapper extends BaseMapper<ProblemCount> {
    ProblemCount getContestProblemCount(@Param("pid") Long pid, @Param("cpid") Long cpid, @Param("cid") Long cid);
}
