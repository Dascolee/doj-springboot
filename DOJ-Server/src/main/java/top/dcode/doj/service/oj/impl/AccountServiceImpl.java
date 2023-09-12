package top.dcode.doj.service.oj.impl;

import org.springframework.stereotype.Service;
import top.dcode.doj.common.exception.StatusFailException;
import top.dcode.doj.common.exception.StatusSystemErrorException;
import top.dcode.doj.common.result.CommonResult;
import top.dcode.doj.common.result.ResultStatus;
import top.dcode.doj.manager.oj.AccountManager;
import top.dcode.doj.pojo.dto.ChangeEmailDTO;
import top.dcode.doj.pojo.dto.ChangePasswordDTO;
import top.dcode.doj.pojo.dto.CheckUsernameOrEmailDTO;
import top.dcode.doj.pojo.vo.*;
import top.dcode.doj.service.oj.AccountService;

import javax.annotation.Resource;


@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountManager accountManager;


    @Override
    public CommonResult<UserCalendarHeatmapVO> getUserCalendarHeatmap(String uid, String username) {
        try {
            return CommonResult.successResponse(accountManager.getUserCalendarHeatmap(uid, username));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }


    @Override
    public CommonResult<UserHomeVO> getUserHomeInfo(String uid, String username) {
        try {
            return CommonResult.successResponse(accountManager.getUserHomeInfo(uid, username));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<ChangeAccountVO> changePassword(ChangePasswordDTO changePasswordDto) {
        try {
            return CommonResult.successResponse(accountManager.changePassword(changePasswordDto));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusSystemErrorException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.SYSTEM_ERROR);
        }
    }

    @Override
    public CommonResult<Void> getChangeEmailCode(String email) {
        try {
            accountManager.getChangeEmailCode(email);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<ChangeAccountVO> changeEmail(ChangeEmailDTO changeEmailDto) {
        try {
            return CommonResult.successResponse(accountManager.changeEmail(changeEmailDto));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusSystemErrorException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.SYSTEM_ERROR);
        }
    }

    @Override
    public CommonResult<UserInfoVO> changeUserInfo(UserInfoVO userInfoVo) {
        try {
            return CommonResult.successResponse(accountManager.changeUserInfo(userInfoVo));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<UserAuthInfoVO> getUserAuthInfo() {
        return CommonResult.successResponse(accountManager.getUserAuthInfo());
    }

}