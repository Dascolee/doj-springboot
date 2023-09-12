package top.dcode.doj.dao.contest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import top.dcode.doj.pojo.entity.contest.Contest;
import top.dcode.doj.pojo.entity.contest.ContestRecord;
import top.dcode.doj.pojo.vo.ContestRecordVO;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 */
public interface ContestRecordEntityService extends IService<ContestRecord> {

    IPage<ContestRecord> getACInfo(Integer currentPage,
                                   Integer limit,
                                   Integer status,
                                   Long cid,
                                   String contestCreatorId,
                                   Date startTime,
                                   Date endTime);

    List<ContestRecordVO> getOIContestRecord(Contest contest, List<Integer> externalCidList,
                                             Boolean isOpenSealRank, Boolean isContainsAfterContestJudge);

    List<ContestRecordVO> getACMContestRecord(String contestCreatorUid, Long cid, List<Integer> externalCidList, Date startTime);

}
