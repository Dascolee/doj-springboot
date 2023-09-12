package top.dcode.doj.service.oj.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import top.dcode.doj.common.exception.StatusAccessDeniedException;
import top.dcode.doj.common.exception.StatusFailException;
import top.dcode.doj.common.exception.StatusForbiddenException;
import top.dcode.doj.common.exception.StatusNotFoundException;
import top.dcode.doj.common.result.CommonResult;
import top.dcode.doj.common.result.ResultStatus;
import top.dcode.doj.manager.oj.ProblemManager;
import top.dcode.doj.pojo.vo.ProblemVO;
import top.dcode.doj.service.oj.ProblemService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 */
@Service
public class ProblemServiceImpl implements ProblemService {

    @Resource
    private ProblemManager problemManager;

    @Override
    public CommonResult<Page<ProblemVO>> getProblemList(Integer limit, Integer currentPage, String keyword, List<Long> tagId, Integer difficulty, String oj) {
        return CommonResult.successResponse(problemManager.getProblemList(limit, currentPage, keyword, tagId, difficulty, oj));
    }

}