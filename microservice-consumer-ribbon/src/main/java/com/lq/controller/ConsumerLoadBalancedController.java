package com.lq.controller;

import com.lq.vo.Product;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * 鸟欲高飞先振翅
 * Created with IntelliJ IDEA.
 * Description:
 *  通过 LoadBalanced负载均衡 服务id的方式 ， 消费者调 用  服务提供者  的方法
 * @author: liqian
 * @Date: 2019-03-17
 * @Time: 11:55
 * 人求上进先读书
 */
@RestController
@RequestMapping(value = "/consumer/loadbalanced")
public class ConsumerLoadBalancedController {

    // 这样的方式是服务消费方直接 从 eureka 服务列表拉取可用服务到本地，然后进行调用，调用方法： 服务方的名称/方法
    // 这个值对应配置文件的值
    public static final String PRODUCT_TOPIC = "microservice-provider-product-ribbon";

    @Resource
    RestTemplate restTemplate;

    @Resource
    HttpHeaders httpHeaders;

    /**
     * 用于获取服务提供方的消息，可以看下面的list方法里面
     */
    @Resource
    LoadBalancerClient loadBalancerClient;

    @RequestMapping("/product/list")
    public  Object listProduct() {
        // 获取调用负载均衡服务提供方的信息
        ServiceInstance instance = loadBalancerClient.choose(PRODUCT_TOPIC);
        if (instance != null) {
            System.out.println("instance.getHost() : "+instance.getHost());
            System.out.println("instance.getServiceId() : "+instance.getServiceId());
            System.out.println("instance.getPort() : "+instance.getPort());
            System.out.println("instance.getUri() : "+instance.getUri());
        }
        try {
            URI uri = new URI(String.format("http://%s:%s/product/list", instance.getHost(), instance.getPort()));
            return restTemplate
                    .exchange(uri, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), List.class)
                    .getBody();
        } catch (URISyntaxException e) {
        }
        return null;
    }


}
