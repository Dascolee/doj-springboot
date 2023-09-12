package top.dcode.doj.dao.problem.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.dcode.doj.dao.problem.ProblemCaseEntityService;
import top.dcode.doj.mapper.ProblemCaseMapper;
import top.dcode.doj.pojo.entity.problem.ProblemCase;

/**
 * @Description:
 */
@Service
public class ProblemCaseEntityServiceImpl extends ServiceImpl<ProblemCaseMapper, ProblemCase> implements ProblemCaseEntityService {
}