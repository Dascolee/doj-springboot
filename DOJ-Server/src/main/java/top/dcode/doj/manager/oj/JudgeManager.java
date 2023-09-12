package top.dcode.doj.manager.oj;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.dcode.doj.common.exception.*;
import top.dcode.doj.config.NacosSwitchConfig;
import top.dcode.doj.dao.contest.ContestEntityService;
import top.dcode.doj.dao.contest.ContestRecordEntityService;
import top.dcode.doj.dao.judge.JudgeEntityService;
import top.dcode.doj.dao.problem.ProblemEntityService;
import top.dcode.doj.dao.user.UserAcproblemEntityService;
import top.dcode.doj.pojo.vo.*;
import top.dcode.doj.shiro.AccountProfile;
import top.dcode.doj.utils.RedisUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**

 */
@Component
public class JudgeManager {
    @Autowired
    private JudgeEntityService judgeEntityService;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private NacosSwitchConfig nacosSwitchConfig;


    /**
     * @MethodName getJudgeList
     * @Description 通用查询判题记录列表
     * @Since 2020/10/29
     */
    public IPage<JudgeVO> getJudgeList(Integer limit,
                                       Integer currentPage,
                                       Boolean onlyMine,
                                       String searchPid,
                                       Integer searchStatus,
                                       String searchUsername,
                                       Boolean completeProblemID,
                                       Long gid) throws StatusAccessDeniedException {
        // 页数，每页题数若为空，设置默认值
        if (currentPage == null || currentPage < 1) currentPage = 1;
        if (limit == null || limit < 1) limit = 30;

        String uid = null;
        // 只查看当前用户的提交
        if (onlyMine) {
            // 需要获取一下该token对应用户的数据（有token便能获取到）
            AccountProfile userRolesVo = (AccountProfile) SecurityUtils.getSubject().getPrincipal();

            if (userRolesVo == null) {
                throw new StatusAccessDeniedException("当前用户数据为空，请您重新登陆！");
            }
            uid = userRolesVo.getUid();
        }
        if (searchPid != null) {
            searchPid = searchPid.trim();
        }
        if (searchUsername != null) {
            searchUsername = searchUsername.trim();
        }

        return judgeEntityService.getCommonJudgeList(limit,
                currentPage,
                searchPid,
                searchStatus,
                searchUsername,
                uid,
                completeProblemID,
                gid);
    }


}