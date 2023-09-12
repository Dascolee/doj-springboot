package top.dcode.doj.manager.oj;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.UnicodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.dcode.doj.config.NacosSwitchConfig;
import top.dcode.doj.config.SwitchConfig;
import top.dcode.doj.config.WebConfig;

import java.util.Map;

@Component
public class HomeManager {


    @Autowired
    private NacosSwitchConfig nacosSwitchConfig;

    /**
     * @MethodName getWebConfig
     * @Params
     * @Description 获取网站的基础配置。例如名字，缩写名字等等。
     * @Return
     * @Since 2020/12/29
     */
    public Map<Object, Object> getWebConfig() {
        SwitchConfig switchConfig = nacosSwitchConfig.getSwitchConfig();
        WebConfig webConfig = nacosSwitchConfig.getWebConfig();
        return MapUtil.builder().put("baseUrl", UnicodeUtil.toString(webConfig.getBaseUrl()))
                .put("name", UnicodeUtil.toString(webConfig.getName()))
                .put("shortName", UnicodeUtil.toString(webConfig.getShortName()))
                .put("register", webConfig.getRegister())
                .put("recordName", UnicodeUtil.toString(webConfig.getRecordName()))
                .put("recordUrl", UnicodeUtil.toString(webConfig.getRecordUrl()))
                .put("description", UnicodeUtil.toString(webConfig.getDescription()))
                .put("email", UnicodeUtil.toString(webConfig.getEmailUsername()))
                .put("projectName", UnicodeUtil.toString(webConfig.getProjectName()))
                .put("projectUrl", UnicodeUtil.toString(webConfig.getProjectUrl()))
                .put("openPublicDiscussion", switchConfig.getOpenPublicDiscussion())
                .put("openGroupDiscussion", switchConfig.getOpenGroupDiscussion())
                .put("openContestComment", switchConfig.getOpenContestComment())
                .map();
    }
}
