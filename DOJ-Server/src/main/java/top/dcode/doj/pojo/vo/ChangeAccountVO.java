package top.dcode.doj.pojo.vo;

import lombok.Data;


@Data
public class ChangeAccountVO {

    private Integer code;

    private String msg;

    private UserInfoVO userInfo;
}