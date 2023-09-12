package top.dcode.doj.controller.oj;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.dcode.doj.annotation.AnonApi;
import top.dcode.doj.common.result.CommonResult;
import top.dcode.doj.pojo.dto.ApplyResetPasswordDTO;
import top.dcode.doj.pojo.dto.LoginDTO;
import top.dcode.doj.pojo.dto.ResetPasswordDTO;
import top.dcode.doj.pojo.vo.UserInfoVO;
import top.dcode.doj.service.oj.PassportService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("api")
public class PassportController {

    @Autowired
    private PassportService passportService;

    @PostMapping("/login")
    @AnonApi
    public CommonResult<UserInfoVO> login(@Validated @RequestBody LoginDTO loginDto, HttpServletResponse response, HttpServletRequest request) {
        CommonResult<UserInfoVO> res = passportService.login(loginDto, response, request);
        System.out.println("登录完成");
        return res;
    }

    /**
     * @MethodName logout
     * @Description 退出逻辑，将jwt在redis中清除，下次需要再次登录。
     * @Return CommonResult
     */
    @GetMapping("/logout")
    @RequiresAuthentication
    public CommonResult<Void> logout() {
        return passportService.logout();
    }

    /**
     * @param applyResetPasswordDto
     * @MethodName applyResetPassword
     * @Description 发送重置密码的链接邮件
     * @Return
     * @Since 2020/11/6
     */
    @PostMapping("/apply-reset-password")
    @AnonApi
    public CommonResult<Void> applyResetPassword(@RequestBody ApplyResetPasswordDTO applyResetPasswordDto) {
        return passportService.applyResetPassword(applyResetPasswordDto);
    }

    /**
     * @param resetPasswordDto
     * @MethodName resetPassword
     * @Description 用户重置密码
     * @Return
     * @Since 2020/11/6
     */
    @PostMapping("/reset-password")
    @AnonApi
    public CommonResult<Void> resetPassword(@RequestBody ResetPasswordDTO resetPasswordDto) {
        return passportService.resetPassword(resetPasswordDto);
    }


}
