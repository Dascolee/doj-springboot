package top.dcode.doj.dao.contest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import top.dcode.doj.pojo.entity.contest.Contest;
import top.dcode.doj.pojo.vo.ContestVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 */
public interface ContestEntityService extends IService<Contest> {

    List<ContestVO> getWithinNext14DaysContests();

    IPage<ContestVO> getContestList(Integer limit, Integer currentPage, Integer type, Integer status, String keyword);

    ContestVO getContestInfoById(long cid);
}
