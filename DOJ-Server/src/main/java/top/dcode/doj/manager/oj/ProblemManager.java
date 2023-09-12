package top.dcode.doj.manager.oj;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import top.dcode.doj.common.exception.StatusAccessDeniedException;
import top.dcode.doj.common.exception.StatusFailException;
import top.dcode.doj.common.exception.StatusForbiddenException;
import top.dcode.doj.common.exception.StatusNotFoundException;
import top.dcode.doj.dao.contest.ContestEntityService;
import top.dcode.doj.dao.judge.JudgeEntityService;
import top.dcode.doj.dao.problem.*;
import top.dcode.doj.exception.AccessException;
import top.dcode.doj.pojo.entity.contest.Contest;
import top.dcode.doj.pojo.entity.judge.Judge;
import top.dcode.doj.pojo.entity.problem.*;
import top.dcode.doj.pojo.vo.*;
import top.dcode.doj.shiro.AccountProfile;
import top.dcode.doj.utils.Constants;


import java.util.*;
import java.util.stream.Collectors;

/**

 */
@Component
public class ProblemManager {
    @Autowired
    private ProblemEntityService problemEntityService;


    /**
     * @MethodName getProblemList
     * @Params * @param null
     * @Description 获取题目列表分页
     * @Since 2020/10/27
     */
    public Page<ProblemVO> getProblemList(Integer limit, Integer currentPage,
                                          String keyword, List<Long> tagId, Integer difficulty, String oj) {
        // 页数，每页题数若为空，设置默认值
        if (currentPage == null || currentPage < 1) currentPage = 1;
        if (limit == null || limit < 1) limit = 10;

        // 关键词查询不为空
        if (!StringUtils.isEmpty(keyword)) {
            keyword = keyword.trim();
        }
        if (oj != null && !Constants.RemoteOJ.isRemoteOJ(oj)) {
            oj = "Mine";
        }
        return problemEntityService.getProblemList(limit, currentPage, null, keyword,
                difficulty, tagId, oj);
    }

}