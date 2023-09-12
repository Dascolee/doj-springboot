package top.dcode.doj.dao.training.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.dcode.doj.dao.training.TrainingCategoryEntityService;
import top.dcode.doj.mapper.TrainingCategoryMapper;
import top.dcode.doj.pojo.entity.training.TrainingCategory;

import javax.annotation.Resource;

/**
 */
@Service
public class TrainingCategoryEntityServiceImpl extends ServiceImpl<TrainingCategoryMapper, TrainingCategory> implements TrainingCategoryEntityService {

    @Resource
    private TrainingCategoryMapper trainingCategoryMapper;

    @Override
    public TrainingCategory getTrainingCategoryByTrainingId(Long tid) {
        return trainingCategoryMapper.getTrainingCategoryByTrainingId(tid);
    }
}