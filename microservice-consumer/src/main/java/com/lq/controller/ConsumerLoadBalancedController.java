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
    public static final String PRODUCT_GET_URL = "http://microservice-provider-product/product/get/";
    public static final String PRODUCT_LIST_URL="http://microservice-provider-product/product/list/";
    public static final String PRODUCT_ADD_URL = "http://microservice-provider-product/product/add/";

    @Resource
    RestTemplate restTemplate;

    @Resource
    HttpHeaders httpHeaders;

    /**
     * 用于获取服务提供方的消息，可以看下面的list方法里面
     */
    @Resource
    LoadBalancerClient loadBalancerClient;


    @RequestMapping("/product/get")
    public Object getProduct(long id) {
        Product product = restTemplate
                .exchange(PRODUCT_GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), Product.class)
                .getBody();
        return  product;
    }

    @RequestMapping("/product/list")
    public  Object listProduct() {
        // 获取调用负载均衡服务提供方的信息
        ServiceInstance instance = loadBalancerClient.choose("microservice-provider-product");
        if (instance != null) {
            System.out.println("instance.getHost() : "+instance.getHost());
            System.out.println("instance.getServiceId() : "+instance.getServiceId());
            System.out.println("instance.getPort() : "+instance.getPort());
            System.out.println("instance.getScheme() : "+instance.getScheme());
            System.out.println("instance.getUri() : "+instance.getUri());
        }

        List<Product> list = restTemplate
                .exchange(PRODUCT_LIST_URL, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), List.class)
                .getBody();
        return  list;
    }

    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
        Boolean result = restTemplate
                .exchange(PRODUCT_ADD_URL, HttpMethod.POST, new HttpEntity<Object>(product, httpHeaders), Boolean.class)
                .getBody();
        return  result;
    }



}
