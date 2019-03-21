package com.lq.service;

import com.lq.vo.Product;

import java.util.List;

/**
 * 鸟欲高飞先振翅
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liqian
 * @Date: 2019-03-17
 * @Time: 10:55
 * 人求上进先读书
 */
public interface IProductService {

    /**
     *
     * @param id
     * @return
     */
    Product get(long id);

    /**
     *
     * @param product
     * @return
     */
    boolean add(Product product);

    /**
     *
     * @return
     */

    List<Product> list();

}
