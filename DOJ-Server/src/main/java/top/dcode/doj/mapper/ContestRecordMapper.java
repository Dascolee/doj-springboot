package top.dcode.doj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.dcode.doj.pojo.entity.contest.ContestRecord;
import top.dcode.doj.pojo.vo.ContestRecordVO;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 */
@Mapper
@Repository
public interface ContestRecordMapper extends BaseMapper<ContestRecord> {
    List<ContestRecord> getACInfo(@Param("status") Integer status, @Param("cid") Long cid);

    List<ContestRecordVO> getOIContestRecordByRecentSubmission(@Param("cid") Long cid,
                                                               @Param("externalCidList") List<Integer> externalCidList,
                                                               @Param("contestCreatorUid") String contestCreatorUid,
                                                               @Param("isOpenSealRank") Boolean isOpenSealRank,
                                                               @Param("sealTime") Long sealTime,
                                                               @Param("endTime") Long endTime,
                                                               @Param("isContainsAfterContestJudge") Boolean isContainsAfterContestJudge);

    List<ContestRecordVO> getOIContestRecordByHighestSubmission(@Param("cid") Long cid,
                                                                @Param("externalCidList") List<Integer> externalCidList,
                                                                @Param("contestCreatorUid") String contestCreatorUid,
                                                                @Param("isOpenSealRank") Boolean isOpenSealRank,
                                                                @Param("sealTime") Long sealTime,
                                                                @Param("endTime") Long endTime,
                                                                @Param("isContainsAfterContestJudge") Boolean isContainsAfterContestJudge);

    List<ContestRecordVO> getACMContestRecord(@Param("contestCreatorUid") String contestCreatorUid,
                                              @Param("cid") Long cid,
                                              @Param("externalCidList") List<Integer> externalCidList,
                                              @Param("time") Long time);
}
