package com.lq.controller;

import com.lq.vo.Product;
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
 *  通过RestTemplate 服务 消费者调 用  服务提供者  的方法
 * @author: liqian
 * @Date: 2019-03-17
 * @Time: 11:55
 * 人求上进先读书
 */
@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {

    // 这样的方式是服务消费方直接 从 服务提供方 调用服务，中间没有经过eureka 这层
    public static final String PRODUCT_GET_URL = "http://localhost:8080/product/get/";
    public static final String PRODUCT_LIST_URL="http://localhost:8080/product/list/";
    public static final String PRODUCT_ADD_URL = "http://localhost:8080/product/add/";

    @Resource
    RestTemplate restTemplate;

    @Resource
    HttpHeaders httpHeaders;


    @RequestMapping("/product/get")
    public Object getProduct(long id) {
        Product product = restTemplate
                .exchange(PRODUCT_GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), Product.class)
                .getBody();
        return  product;
    }

    @RequestMapping("/product/list")
    public  Object listProduct() {
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
