package top.dcode.doj.service.oj.impl;

import org.springframework.stereotype.Service;
import top.dcode.doj.common.exception.StatusFailException;
import top.dcode.doj.common.result.CommonResult;
import top.dcode.doj.manager.oj.PassportManager;
import top.dcode.doj.pojo.dto.ApplyResetPasswordDTO;
import top.dcode.doj.pojo.dto.LoginDTO;
import top.dcode.doj.pojo.dto.ResetPasswordDTO;
import top.dcode.doj.pojo.vo.UserInfoVO;
import top.dcode.doj.service.oj.PassportService;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class PassportServiceImpl implements PassportService {

    @Resource
    private PassportManager passportManager;

    @Override
    public CommonResult<UserInfoVO> login(LoginDTO loginDto, HttpServletResponse response, HttpServletRequest request) {
        try {
            return CommonResult.successResponse(passportManager.login(loginDto, response, request));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> applyResetPassword(ApplyResetPasswordDTO applyResetPasswordDto) {
        try {
            passportManager.applyResetPassword(applyResetPasswordDto);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> resetPassword(ResetPasswordDTO resetPasswordDto) {
        try {
            passportManager.resetPassword(resetPasswordDto);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }


    @Override
    public CommonResult<Void> logout() {
        passportManager.logout();
        return CommonResult.successResponse("登出成功");
    }
}