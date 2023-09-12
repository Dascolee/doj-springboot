package top.dcode.doj.dao.problem.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.dcode.doj.dao.problem.ProblemTagEntityService;
import top.dcode.doj.mapper.ProblemTagMapper;
import top.dcode.doj.pojo.entity.problem.ProblemTag;

/**
 * @Description:
 */
@Service
public class ProblemTagEntityServiceImpl extends ServiceImpl<ProblemTagMapper, ProblemTag> implements ProblemTagEntityService {
}