package top.dcode.doj.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @描述
 */
@Component
@RefreshScope
@ConfigurationProperties(prefix = "doj.db")
@Data
public class DataSourceConfigure {

    private String username;

    private String password;

    private String host;

    private Integer port;

    private String name;
}
