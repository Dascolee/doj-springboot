package top.dcode.doj.dao.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import top.dcode.doj.pojo.entity.judge.Judge;
import top.dcode.doj.pojo.entity.user.UserRecord;
import top.dcode.doj.pojo.vo.UserHomeVO;

import java.util.List;

/**
 */
public interface UserRecordEntityService extends IService<UserRecord> {

    UserHomeVO getUserHomeInfo(String uid, String username);

    List<Judge> getLastYearUserJudgeList(String uid, String username);

}
