package top.dcode.doj.service.oj;


import top.dcode.doj.pojo.dto.ApplyResetPasswordDTO;
import top.dcode.doj.pojo.dto.LoginDTO;
import top.dcode.doj.pojo.dto.ResetPasswordDTO;
import top.dcode.doj.pojo.vo.UserInfoVO;
import top.dcode.doj.common.result.CommonResult;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 */
public interface PassportService {

    public CommonResult<UserInfoVO> login(LoginDTO loginDto, HttpServletResponse response, HttpServletRequest request);

    public CommonResult<Void> applyResetPassword(ApplyResetPasswordDTO applyResetPasswordDto);

    public CommonResult<Void> resetPassword(ResetPasswordDTO resetPasswordDto);

    public CommonResult<Void> logout();
}