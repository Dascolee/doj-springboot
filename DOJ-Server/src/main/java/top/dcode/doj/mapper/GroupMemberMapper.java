package top.dcode.doj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.dcode.doj.pojo.entity.group.GroupMember;
import top.dcode.doj.pojo.vo.GroupMemberVO;

import java.util.List;

/**
 */
@Mapper
@Repository
public interface GroupMemberMapper extends BaseMapper<GroupMember> {
    List<GroupMemberVO> getMemberList(IPage iPage, @Param("keyword") String keyword, @Param("auth") Integer auth, @Param("gid") Long gid);
    List<GroupMemberVO> getApplyList(IPage iPage, @Param("keyword") String keyword, @Param("auth") Integer auth, @Param("gid") Long gid);
}
