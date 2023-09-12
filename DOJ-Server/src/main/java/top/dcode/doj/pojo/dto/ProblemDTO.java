package top.dcode.doj.pojo.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import top.dcode.doj.pojo.entity.problem.*;

import java.util.List;


/**
 */
@Data
@Accessors(chain = true)
public class ProblemDTO {

    private Problem problem;

    private List<ProblemCase> samples;

    private Boolean isUploadTestCase;

    private String uploadTestcaseDir;

    private String judgeMode;

    private Boolean changeModeCode;

    private Boolean changeJudgeCaseMode;

    private List<Language> languages;

    private List<Tag> tags;

    private List<CodeTemplate> codeTemplates;

}