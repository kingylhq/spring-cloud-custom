package com.lq;

import com.yh.RibbonRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 服务消费者启动类
 */
@SpringBootApplication
@EnableEurekaClient

// 对microservice-provider-product 服务提供方 进行随机访问
@RibbonClient(name = "microservice-provider-product", configuration = RibbonRuleConfig.class)
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
