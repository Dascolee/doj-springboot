package top.dcode.doj.dao.problem;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import top.dcode.doj.pojo.dto.ProblemDTO;
import top.dcode.doj.pojo.entity.problem.Problem;
import top.dcode.doj.pojo.vo.ImportProblemVO;
import top.dcode.doj.pojo.vo.ProblemVO;

import java.util.HashMap;
import java.util.List;


/**
 * <p>
 * 服务类
 * </p>
 */

public interface ProblemEntityService extends IService<Problem> {
    Page<ProblemVO> getProblemList(int limit, int currentPage, Long pid, String title,
                                   Integer difficulty, List<Long> tid, String oj);

    boolean adminUpdateProblem(ProblemDTO problemDto);

    boolean adminAddProblem(ProblemDTO problemDto);

    ImportProblemVO buildExportProblem(Long pid, List<HashMap<String, Object>> problemCaseList, HashMap<Long, String> languageMap, HashMap<Long, String> tagMap);
}
