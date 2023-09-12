package top.dcode.doj;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync(proxyTargetClass=true) //开启异步注解
@EnableDiscoveryClient
@SpringBootApplication
public class DOJServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DOJServerApplication.class,args);
        System.out.println("DOJ-SERVER 启动成功");
    }
}
