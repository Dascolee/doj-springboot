package top.dcode.doj.service.oj;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.dcode.doj.common.result.CommonResult;
import top.dcode.doj.pojo.vo.ProblemVO;


import java.util.HashMap;
import java.util.List;

/**
 */
public interface ProblemService {

    public CommonResult<Page<ProblemVO>> getProblemList(Integer limit, Integer currentPage,
                                                        String keyword, List<Long> tagId, Integer difficulty, String oj);

}