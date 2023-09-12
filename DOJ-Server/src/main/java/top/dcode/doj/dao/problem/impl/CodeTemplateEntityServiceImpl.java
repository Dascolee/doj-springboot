package top.dcode.doj.dao.problem.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.dcode.doj.dao.problem.CodeTemplateEntityService;
import top.dcode.doj.mapper.CodeTemplateMapper;
import top.dcode.doj.pojo.entity.problem.CodeTemplate;

/**
 * @Description:
 */
@Service
public class CodeTemplateEntityServiceImpl extends ServiceImpl<CodeTemplateMapper, CodeTemplate> implements CodeTemplateEntityService {
}