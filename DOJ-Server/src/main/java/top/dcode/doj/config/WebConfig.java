package top.dcode.doj.config;

import lombok.Data;
import top.dcode.doj.utils.IpUtils;

@Data
public class WebConfig {

    // 邮箱配置
    private String emailUsername;

    private String emailPassword;

    private String emailHost;

    private Integer emailPort;

    private Boolean emailSsl = true;

    private String emailBGImg = "https://cdn.jsdelivr.net/gh/HimitZH/CDN/images/HCODE.png";

    // 网站前端显示配置
    private String baseUrl = "http://" + IpUtils.getServiceIp();

    private String name = "Dcode Online Judge";

    private String shortName = "DOJ";

    private String description;

    private Boolean register = true;

    private String recordName;

    private String recordUrl;

    private String projectName = "DOJ";

    private String projectUrl = "https://gitee.com/dascolee/hoj";
}
