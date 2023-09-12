package top.dcode.doj.dao.user.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dcode.doj.dao.user.UserRecordEntityService;
import top.dcode.doj.mapper.JudgeMapper;
import top.dcode.doj.mapper.UserRecordMapper;
import top.dcode.doj.pojo.entity.judge.Judge;
import top.dcode.doj.pojo.entity.user.UserRecord;
import top.dcode.doj.pojo.vo.UserHomeVO;
import top.dcode.doj.utils.Constants;
import top.dcode.doj.utils.RedisUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 */
@Service
public class UserRecordEntityServiceImpl extends ServiceImpl<UserRecordMapper, UserRecord>
        implements UserRecordEntityService {

    @Autowired
    private UserRecordMapper userRecordMapper;

    @Autowired
    private JudgeMapper judgeMapper;

    @Autowired
    private RedisUtils redisUtils;

    // 排行榜缓存时间 10s
    private static final long cacheRankSecond = 10;

    @Override
    public UserHomeVO getUserHomeInfo(String uid, String username) {
        return userRecordMapper.getUserHomeInfo(uid, username);
    }

    @Override
    public List<Judge> getLastYearUserJudgeList(String uid, String username) {
        return judgeMapper.getLastYearUserJudgeList(uid, username);
    }

}
