package top.dcode.doj.service.oj;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.dcode.doj.common.result.CommonResult;
import top.dcode.doj.pojo.vo.JudgeVO;


import java.util.HashMap;

public interface JudgeService {


    public CommonResult<IPage<JudgeVO>> getJudgeList(Integer limit,
                                                     Integer currentPage,
                                                     Boolean onlyMine,
                                                     String searchPid,
                                                     Integer searchStatus,
                                                     String searchUsername,
                                                     Boolean completeProblemID,
                                                     Long gid);

}
