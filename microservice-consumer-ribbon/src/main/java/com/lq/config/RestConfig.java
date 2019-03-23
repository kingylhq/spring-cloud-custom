package com.lq.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * 鸟欲高飞先振翅
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liqian
 * @Date: 2019-03-17
 * @Time: 11:52
 * 人求上进先读书
 */
@Configuration
public class RestConfig {

    @Bean
    // 用springcloud ribbon 的方式就需要注释掉 @LoadBalanced
//    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    /**
     * 要进行一个Http头信息配置
     * @return
     */
    @Bean
    public HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        // 认证的原始信息
        String auth = "admin:admin";
        // 进行一个加密处理
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic "+ new String(encodedAuth);
        httpHeaders.set("Authorization", authHeader);
        return httpHeaders;
    }

    /**
     *  IRule 是所有规则的标准
     * 1、支持对产品服务提供方高可用集群部署的随机访问
     * 2、如果需要对服务的某个服务添加单独的访问方式，则需要注释掉此 Bean
     * @return
     */
//    @Bean
//    public IRule ribbonRule() {
//        // ribbon 随机访问规则
//        return new com.netflix.loadbalancer.RandomRule();
//    }
}
