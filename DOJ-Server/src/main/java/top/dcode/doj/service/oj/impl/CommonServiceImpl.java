package top.dcode.doj.service.oj.impl;

import org.springframework.stereotype.Service;
import top.dcode.doj.common.result.CommonResult;
import top.dcode.doj.manager.oj.CommonManager;
import top.dcode.doj.pojo.entity.problem.CodeTemplate;
import top.dcode.doj.pojo.entity.problem.Language;
import top.dcode.doj.pojo.entity.problem.Tag;
import top.dcode.doj.pojo.entity.training.TrainingCategory;
import top.dcode.doj.pojo.vo.CaptchaVO;
import top.dcode.doj.pojo.vo.ProblemTagVO;
import top.dcode.doj.service.oj.CommonService;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;


@Service
public class CommonServiceImpl implements CommonService {

    @Resource
    private CommonManager commonManager;

    @Override
    public CommonResult<List<Tag>> getAllProblemTagsList(String oj) {
        return CommonResult.successResponse(commonManager.getAllProblemTagsList(oj));
    }

    @Override
    public CommonResult<List<ProblemTagVO>> getProblemTagsAndClassification(String oj) {
        return CommonResult.successResponse(commonManager.getProblemTagsAndClassification(oj));
    }

}