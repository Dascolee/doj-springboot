package top.dcode.doj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.dcode.doj.pojo.entity.discussion.Comment;
import top.dcode.doj.pojo.vo.CommentVO;

import java.util.List;


/**
 * <p>
 * Mapper 接口
 * </p>

 */
@Mapper
@Repository
public interface CommentMapper extends BaseMapper<Comment> {

    IPage<CommentVO> getCommentList(Page<CommentVO> page,
                                    @Param("cid") Long cid,
                                    @Param("did") Integer did,
                                    @Param("onlyMineAndAdmin") Boolean onlyMineAndAdmin,
                                    @Param("myAndAdminUidList") List<String> myAndAdminUidList);
}
