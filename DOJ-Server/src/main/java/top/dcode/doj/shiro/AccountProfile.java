package top.dcode.doj.shiro;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
public class AccountProfile implements Serializable {

    @ApiModelProperty(value = "用户id")
    private String uid;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "真实姓名")
    private String realname;

    @ApiModelProperty(value = "头衔名称")
    private String titleName;

    @ApiModelProperty(value = "头衔背景颜色")
    private String titleColor;

    @ApiModelProperty(value = "头像地址")
    private String avatar;

    @ApiModelProperty(value = "0可用，1不可用")
    private int status;

    public String getId() { //shiro登录用户实体默认主键获取方法要为getId
        return uid;
    }
}