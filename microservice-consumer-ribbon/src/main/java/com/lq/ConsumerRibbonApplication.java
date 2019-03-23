package com.lq;

import com.yh.RibbonRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 服务消费者启动类
 *
 * springcloud ribbon 脱离springcloud eureka,进行服务调用
 */
@SpringBootApplication
@EnableDiscoveryClient
// 对microservice-provider-product-ribbon ,这个地方的name = "microservice-provider-product-ribbon" 值和配置文件的值对应
// 服务提供方 进行随机访问
@RibbonClient(name = "microservice-provider-product-ribbon", configuration = RibbonRuleConfig.class)
public class ConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonApplication.class, args);
    }

}
