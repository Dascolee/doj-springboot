package top.dcode.doj.pojo.dto;

import lombok.Data;

/**
 * @Description:
 */

@Data
public class ResetPasswordDTO {

    private String username;

    private String password;

    private String code;
}