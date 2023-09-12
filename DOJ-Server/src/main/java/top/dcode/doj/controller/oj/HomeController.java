package top.dcode.doj.controller.oj;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.dcode.doj.annotation.AnonApi;
import top.dcode.doj.common.result.CommonResult;
import top.dcode.doj.service.oj.HomeService;

import java.util.Map;


/**
 * 处理首页的请求
 */
@RestController
@RequestMapping("/api")
@AnonApi
public class HomeController {


    @Autowired
    private HomeService homeService;


    /**
     * @MethodName getWebConfig
     * @Params
     * @Description 获取网站的基础配置。例如名字，缩写名字等等。
     * @Return CommonResult
     * @Since 2023/08/04
     */
    @GetMapping("/get-website-config")
    public CommonResult<Map<Object, Object>> getWebConfig() {
        CommonResult<Map<Object, Object>> res = homeService.getWebConfig();
        return res;
    }


}
