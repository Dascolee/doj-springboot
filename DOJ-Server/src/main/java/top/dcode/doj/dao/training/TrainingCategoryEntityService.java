package top.dcode.doj.dao.training;

import com.baomidou.mybatisplus.extension.service.IService;
import top.dcode.doj.pojo.entity.training.TrainingCategory;

public interface TrainingCategoryEntityService extends IService<TrainingCategory> {

    public TrainingCategory getTrainingCategoryByTrainingId(Long tid);
}
