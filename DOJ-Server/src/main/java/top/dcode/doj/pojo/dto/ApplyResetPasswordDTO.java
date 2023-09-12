package top.dcode.doj.pojo.dto;

import lombok.Data;

/**
 * @Description:
 */
@Data
public class ApplyResetPasswordDTO {

    private String captcha;

    private String captchaKey;

    private String email;
}