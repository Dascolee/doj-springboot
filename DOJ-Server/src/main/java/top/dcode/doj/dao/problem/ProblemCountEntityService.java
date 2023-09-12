package top.dcode.doj.dao.problem;

import com.baomidou.mybatisplus.extension.service.IService;
import top.dcode.doj.pojo.entity.problem.ProblemCount;

/**
 * 服务类
 */
public interface ProblemCountEntityService extends IService<ProblemCount> {
    ProblemCount getContestProblemCount(Long pid, Long cpid, Long cid);
}
