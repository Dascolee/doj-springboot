package top.dcode.doj.service.oj;

import top.dcode.doj.common.result.CommonResult;
import top.dcode.doj.pojo.dto.ChangeEmailDTO;
import top.dcode.doj.pojo.dto.ChangePasswordDTO;
import top.dcode.doj.pojo.dto.CheckUsernameOrEmailDTO;
import top.dcode.doj.pojo.vo.*;


public interface AccountService {

    public CommonResult<UserCalendarHeatmapVO> getUserCalendarHeatmap(String uid, String username);

    public CommonResult<UserHomeVO> getUserHomeInfo(String uid, String username);

    public CommonResult<ChangeAccountVO> changePassword(ChangePasswordDTO changePasswordDto);

    public CommonResult<Void> getChangeEmailCode(String email);

    public CommonResult<ChangeAccountVO> changeEmail(ChangeEmailDTO changeEmailDto);

    public CommonResult<UserInfoVO> changeUserInfo(UserInfoVO userInfoVo);

    public CommonResult<UserAuthInfoVO> getUserAuthInfo();

}
