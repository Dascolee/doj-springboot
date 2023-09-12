package top.dcode.doj.dao.problem.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.dcode.doj.dao.problem.ProblemLanguageEntityService;
import top.dcode.doj.mapper.ProblemLanguageMapper;
import top.dcode.doj.pojo.entity.problem.ProblemLanguage;

/**
 * @Description:
 */
@Service
public class ProblemLanguageEntityServiceImpl extends ServiceImpl<ProblemLanguageMapper, ProblemLanguage> implements ProblemLanguageEntityService {
}