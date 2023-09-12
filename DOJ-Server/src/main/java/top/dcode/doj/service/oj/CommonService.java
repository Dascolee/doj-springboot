package top.dcode.doj.service.oj;

import top.dcode.doj.common.result.CommonResult;
import top.dcode.doj.pojo.entity.problem.CodeTemplate;
import top.dcode.doj.pojo.entity.problem.Language;
import top.dcode.doj.pojo.entity.problem.Tag;
import top.dcode.doj.pojo.entity.training.TrainingCategory;
import top.dcode.doj.pojo.vo.CaptchaVO;
import top.dcode.doj.pojo.vo.ProblemTagVO;

import java.util.Collection;
import java.util.List;

public interface CommonService {

    public CommonResult<List<Tag>> getAllProblemTagsList(String oj);

    public CommonResult<List<ProblemTagVO>> getProblemTagsAndClassification(String oj);

}
