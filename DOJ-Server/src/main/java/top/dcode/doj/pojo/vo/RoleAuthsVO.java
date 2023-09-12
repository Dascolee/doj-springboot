package top.dcode.doj.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.dcode.doj.pojo.entity.user.Auth;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 */
@ApiModel(value="角色以及其对应的权限列表", description="")
@Data
public class RoleAuthsVO {

    @ApiModelProperty(value = "角色id")
    private Long id;

    @ApiModelProperty(value = "角色")
    private String role;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "默认0可用，1不可用")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;

    @ApiModelProperty(value = "权限列表")
    private List<Auth> auths;
}