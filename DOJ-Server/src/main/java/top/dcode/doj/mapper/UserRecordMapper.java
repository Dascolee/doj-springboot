package top.dcode.doj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.dcode.doj.pojo.entity.user.UserRecord;
import top.dcode.doj.pojo.vo.ACMRankVO;
import top.dcode.doj.pojo.vo.OIRankVO;
import top.dcode.doj.pojo.vo.UserHomeVO;

import java.util.List;


@Mapper
@Repository
public interface UserRecordMapper extends BaseMapper<UserRecord> {
    IPage<ACMRankVO> getACMRankList(Page<ACMRankVO> page, @Param("uidList") List<String> uidList);

    List<ACMRankVO> getRecent7ACRank();

    IPage<OIRankVO> getOIRankList(Page<OIRankVO> page, @Param("uidList") List<String> uidList);

    UserHomeVO getUserHomeInfo(@Param("uid") String uid, @Param("username") String username);

    IPage<OIRankVO> getGroupRankList(Page<OIRankVO> page,
                                     @Param("gid") Long gid,
                                     @Param("uidList") List<String> uidList,
                                     @Param("rankType") String rankType);

}
