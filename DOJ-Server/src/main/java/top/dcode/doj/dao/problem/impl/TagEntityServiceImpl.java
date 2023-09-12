package top.dcode.doj.dao.problem.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.dcode.doj.dao.problem.TagEntityService;
import top.dcode.doj.mapper.TagMapper;
import top.dcode.doj.pojo.entity.problem.Tag;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class TagEntityServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagEntityService {

}
