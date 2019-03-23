package com.lq.controller;

import com.lq.service.IProductService;
import com.lq.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 鸟欲高飞先振翅
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liqian
 * @Date: 2019-03-17
 * @Time: 11:01
 * 人求上进先读书
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Resource
    IProductService productService;

    // import org.springframework.cloud.client.discovery.DiscoveryClient; 这个包下面的类
    @Resource
    DiscoveryClient discoveryClient;

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping(value="/get/{id}")
    public Object get(@PathVariable("id") long id) {
        return this.productService.get(id) ;
    }

    /**
     * 添加
     * @param product
     * @return
     */
    @RequestMapping(value="/add")
    public Object add(@RequestBody Product product) {
        return this.productService.add(product) ;
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value="/list")
    public Object list() {
        return this.productService.list() ;
    }

    /**
     * 发现Eureka客户端信息
     * @return
     */
    @RequestMapping(value="/discoverClient")
    public Object discoverClient() {
        return this.discoveryClient;
    }





}
