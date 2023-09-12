package top.dcode.doj.manager.oj;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.base.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import top.dcode.doj.dao.problem.*;
import top.dcode.doj.dao.training.TrainingCategoryEntityService;
import top.dcode.doj.pojo.entity.problem.*;
import top.dcode.doj.pojo.entity.training.TrainingCategory;
import top.dcode.doj.pojo.vo.CaptchaVO;
import top.dcode.doj.pojo.vo.ProblemTagVO;
import top.dcode.doj.utils.RedisUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 */
@Component
public class CommonManager {

    @Autowired
    private TagEntityService tagEntityService;

    @Autowired
    private TagClassificationEntityService tagClassificationEntityService;

    @Autowired
    private ProblemTagEntityService problemTagEntityService;

    @Autowired
    private ProblemLanguageEntityService problemLanguageEntityService;

    @Autowired
    private RedisUtils redisUtil;

    @Autowired
    private ProblemEntityService problemEntityService;

    @Autowired
    private CodeTemplateEntityService codeTemplateEntityService;

    public List<Tag> getAllProblemTagsList(String oj) {
        List<Tag> tagList;
        oj = oj.toUpperCase();
        QueryWrapper<Tag> tagQueryWrapper = new QueryWrapper<>();
        tagQueryWrapper.isNull("gid");
        if (oj.equals("ALL")) {
            tagList = tagEntityService.list(tagQueryWrapper);
        } else {
            tagQueryWrapper.eq("oj", oj);
            tagList = tagEntityService.list(tagQueryWrapper);
        }
        return tagList;
    }

    public List<ProblemTagVO> getProblemTagsAndClassification(String oj) {
        oj = oj.toUpperCase();
        List<ProblemTagVO> problemTagVOList = new ArrayList<>();
        List<TagClassification> classificationList = null;
        List<Tag> tagList = null;
        if (oj.equals("ALL")) {
            classificationList = tagClassificationEntityService.list();
            QueryWrapper<Tag> tagQueryWrapper = new QueryWrapper<>();
            tagQueryWrapper.isNull("gid");
            tagList = tagEntityService.list(tagQueryWrapper);
        } else {
            QueryWrapper<TagClassification> tagClassificationQueryWrapper = new QueryWrapper<>();
            tagClassificationQueryWrapper.eq("oj", oj)
                    .orderByAsc("`rank`");
            classificationList = tagClassificationEntityService.list(tagClassificationQueryWrapper);

            QueryWrapper<Tag> tagQueryWrapper = new QueryWrapper<>();
            tagQueryWrapper.isNull("gid");
            tagQueryWrapper.eq("oj", oj);
            tagList = tagEntityService.list(tagQueryWrapper);
        }
        if (CollectionUtils.isEmpty(classificationList)) {
            ProblemTagVO problemTagVo = new ProblemTagVO();
            problemTagVo.setTagList(tagList);
            problemTagVOList.add(problemTagVo);
        } else {
            for (TagClassification classification : classificationList) {
                ProblemTagVO problemTagVo = new ProblemTagVO();
                problemTagVo.setClassification(classification);
                List<Tag> tags = new ArrayList<>();
                if (!CollectionUtils.isEmpty(tagList)) {
                    Iterator<Tag> it = tagList.iterator();
                    while (it.hasNext()) {
                        Tag tag = it.next();
                        if (classification.getId().equals(tag.getTcid())) {
                            tags.add(tag);
                            it.remove();
                        }
                    }
                }
                problemTagVo.setTagList(tags);
                problemTagVOList.add(problemTagVo);
            }
            if (tagList.size() > 0) {
                ProblemTagVO problemTagVo = new ProblemTagVO();
                problemTagVo.setTagList(tagList);
                problemTagVOList.add(problemTagVo);
            }
        }

        if (oj.equals("ALL")) {
            Collections.sort(problemTagVOList, problemTagVoComparator);
        }
        return problemTagVOList;
    }

    private Comparator<ProblemTagVO> problemTagVoComparator = (p1, p2) -> {
        if (p1 == null) {
            return 1;
        }
        if (p2 == null) {
            return 1;
        }
        if (p1.getClassification() == null) {
            return 1;
        }
        if (p2.getClassification() == null) {
            return -1;
        }
        TagClassification p1Classification = p1.getClassification();
        TagClassification p2Classification = p2.getClassification();
        if (Objects.equals(p1Classification.getOj(), p2Classification.getOj())) {
            return p1Classification.getRank().compareTo(p2Classification.getRank());
        } else {
            if ("ME".equals(p1Classification.getOj())) {
                return -1;
            } else if ("ME".equals(p2Classification.getOj())) {
                return 1;
            } else {
                return p1Classification.getOj().compareTo(p2Classification.getOj());
            }
        }
    };
}