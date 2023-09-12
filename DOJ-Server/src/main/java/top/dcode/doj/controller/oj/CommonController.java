package top.dcode.doj.controller.oj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.dcode.doj.annotation.AnonApi;
import top.dcode.doj.common.result.CommonResult;
import top.dcode.doj.pojo.entity.problem.CodeTemplate;
import top.dcode.doj.pojo.entity.problem.Language;
import top.dcode.doj.pojo.entity.problem.Tag;
import top.dcode.doj.pojo.entity.training.TrainingCategory;
import top.dcode.doj.pojo.vo.CaptchaVO;
import top.dcode.doj.pojo.vo.ProblemTagVO;
import top.dcode.doj.service.oj.CommonService;

import java.util.Collection;
import java.util.List;


/*
 * @Description: 通用的请求控制处理类
 */
@RestController
@RequestMapping("/api")
public class CommonController {

    @Autowired
    private CommonService commonService;


    @GetMapping("/get-all-problem-tags")
    @AnonApi
    public CommonResult<List<Tag>> getAllProblemTagsList(@RequestParam(value = "oj", defaultValue = "ME") String oj) {
        return commonService.getAllProblemTagsList(oj);
    }

    @GetMapping("/get-problem-tags-and-classification")
    @AnonApi
    public CommonResult<List<ProblemTagVO>> getProblemTagsAndClassification(@RequestParam(value = "oj", defaultValue = "ME") String oj) {
        return commonService.getProblemTagsAndClassification(oj);
    }

}
