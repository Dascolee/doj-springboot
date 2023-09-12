package top.dcode.doj.service.oj.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import top.dcode.doj.common.result.CommonResult;
import top.dcode.doj.manager.oj.HomeManager;
import top.dcode.doj.pojo.vo.*;
import top.dcode.doj.service.oj.HomeService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class HomeServiceImpl implements HomeService {

    @Resource
    private HomeManager homeManager;

    @Override
    public CommonResult<Map<Object, Object>> getWebConfig() {
        return CommonResult.successResponse(homeManager.getWebConfig());
    }


}