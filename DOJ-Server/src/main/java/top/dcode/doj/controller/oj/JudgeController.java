package top.dcode.doj.controller.oj;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.dcode.doj.annotation.AnonApi;
import top.dcode.doj.common.result.CommonResult;
import top.dcode.doj.pojo.vo.JudgeVO;
import top.dcode.doj.service.oj.JudgeService;


/**
 *@Description: 处理代码评判相关业务
 */
@RestController
@RequestMapping("/api")
public class JudgeController {

    @Autowired
    private JudgeService judgeService;
    /**
     * @param limit
     * @param currentPage
     * @param onlyMine
     * @param searchPid
     * @param searchStatus
     * @param searchUsername
     * @param completeProblemID
     * @MethodName getJudgeList
     * @Description 通用查询判题记录列表
     * @Return CommonResult
     * @Since 2020/10/29
     */
    @GetMapping("/get-submission-list")
    @AnonApi
    public CommonResult<IPage<JudgeVO>> getJudgeList(@RequestParam(value = "limit", required = false) Integer limit,
                                                     @RequestParam(value = "currentPage", required = false) Integer currentPage,
                                                     @RequestParam(value = "onlyMine", required = false) Boolean onlyMine,
                                                     @RequestParam(value = "problemID", required = false) String searchPid,
                                                     @RequestParam(value = "status", required = false) Integer searchStatus,
                                                     @RequestParam(value = "username", required = false) String searchUsername,
                                                     @RequestParam(value = "completeProblemID", defaultValue = "false") Boolean completeProblemID,
                                                     @RequestParam(value = "gid", required = false) Long gid) {

        return judgeService.getJudgeList(limit, currentPage, onlyMine, searchPid, searchStatus, searchUsername, completeProblemID, gid);
    }

}
