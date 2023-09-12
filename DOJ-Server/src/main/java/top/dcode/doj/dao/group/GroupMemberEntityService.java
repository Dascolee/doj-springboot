package top.dcode.doj.dao.group;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import top.dcode.doj.pojo.entity.group.GroupMember;
import top.dcode.doj.pojo.vo.GroupMemberVO;

import java.util.List;

/**
 */
public interface GroupMemberEntityService extends IService<GroupMember> {

    IPage<GroupMemberVO> getMemberList(int limit, int currentPage, String keyword, Integer auth, Long gid);

    IPage<GroupMemberVO> getApplyList(int limit, int currentPage, String keyword, Integer auth, Long gid);

    List<String> getGroupRootUidList(Long gid);

    void addApplyNoticeToGroupRoot(Long gid, String groupName, String newMemberUid);

    void addWelcomeNoticeToGroupNewMember(Long gid, String groupName,String memberUid);

    void addRemoveNoticeToGroupMember(Long gid, String groupName, String operator, String memberUid);

    void addDissolutionNoticeToGroupMember(Long gid, String groupName, List<String> groupMemberUidList, String operator);
}
