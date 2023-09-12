package top.dcode.doj.service.oj;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.dcode.doj.common.result.CommonResult;
import top.dcode.doj.pojo.vo.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 */
public interface HomeService {
    public CommonResult<Map<Object, Object>> getWebConfig();
}