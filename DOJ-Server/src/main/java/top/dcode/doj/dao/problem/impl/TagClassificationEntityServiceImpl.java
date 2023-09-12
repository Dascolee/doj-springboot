package top.dcode.doj.dao.problem.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.dcode.doj.dao.problem.TagClassificationEntityService;
import top.dcode.doj.mapper.TagClassificationMapper;
import top.dcode.doj.pojo.entity.problem.TagClassification;

/**
 */
@Service
public class TagClassificationEntityServiceImpl extends ServiceImpl<TagClassificationMapper, TagClassification> implements TagClassificationEntityService {
}
