package top.dcode.doj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.dcode.doj.pojo.entity.group.Group;
import top.dcode.doj.pojo.vo.GroupVO;

import java.util.List;

/**
 */
@Mapper
@Repository
public interface GroupMapper extends BaseMapper<Group> {
    List<GroupVO> getGroupList(IPage iPage,
                               @Param("keyword") String keyword,
                               @Param("auth") Integer auth,
                               @Param("uid") String uid,
                               @Param("onlyMine") Boolean onlyMine,
                               @Param("isRoot") Boolean isRoot);
}
