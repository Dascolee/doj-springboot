package top.dcode.doj.pojo.vo;

import lombok.Data;
import top.dcode.doj.pojo.entity.problem.Tag;
import top.dcode.doj.pojo.entity.problem.TagClassification;

import java.io.Serializable;
import java.util.List;

/**
 */
@Data
public class ProblemTagVO implements Serializable {
    /**
     * 标签分类
     */
    private TagClassification classification;

    /**
     * 标签列表
     */
    private List<Tag> tagList;

}
