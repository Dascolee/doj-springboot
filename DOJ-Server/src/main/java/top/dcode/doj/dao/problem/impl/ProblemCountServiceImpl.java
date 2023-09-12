package top.dcode.doj.dao.problem.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dcode.doj.dao.problem.ProblemCountEntityService;
import top.dcode.doj.mapper.ProblemCountMapper;
import top.dcode.doj.pojo.entity.problem.ProblemCount;

/**
 *  服务实现类
 */
@Service
public class ProblemCountServiceImpl extends ServiceImpl<ProblemCountMapper, ProblemCount> implements ProblemCountEntityService {

    @Autowired
    private ProblemCountMapper problemCountMapper;

    @Override
    public ProblemCount getContestProblemCount(Long pid, Long cpid, Long cid) {
        return problemCountMapper.getContestProblemCount(pid,cpid, cid);
    }
}
