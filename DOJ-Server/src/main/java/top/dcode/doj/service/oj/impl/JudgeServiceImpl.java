package top.dcode.doj.service.oj.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import top.dcode.doj.manager.oj.JudgeManager;
import top.dcode.doj.service.oj.JudgeService;
import top.dcode.doj.common.exception.*;
import top.dcode.doj.common.result.CommonResult;
import top.dcode.doj.common.result.ResultStatus;
import top.dcode.doj.pojo.vo.JudgeVO;


import javax.annotation.Resource;
import java.util.HashMap;


@Service
public class JudgeServiceImpl implements JudgeService {

    @Resource
    private JudgeManager judgeManager;


    @Override
    public CommonResult<IPage<JudgeVO>> getJudgeList(Integer limit,
                                                     Integer currentPage,
                                                     Boolean onlyMine,
                                                     String searchPid,
                                                     Integer searchStatus,
                                                     String searchUsername,
                                                     Boolean completeProblemID,
                                                     Long gid) {
        try {
            return CommonResult.successResponse(judgeManager.getJudgeList(limit,
                    currentPage,
                    onlyMine,
                    searchPid,
                    searchStatus,
                    searchUsername,
                    completeProblemID,
                    gid));
        } catch (StatusAccessDeniedException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.ACCESS_DENIED);
        }
    }


}