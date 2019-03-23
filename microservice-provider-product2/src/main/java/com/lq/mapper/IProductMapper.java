package com.lq.mapper;

import com.lq.vo.Product;

import java.util.List;

/**
 * 鸟欲高飞先振翅
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liqian
 * @Date: 2019-03-17
 * @Time: 10:46
 * 人求上进先读书
 */
public interface IProductMapper {

    /**
     *
     * @param product
     * @return
     */
    boolean create(Product product);

    /**
     *
     * @param id
     * @return
     */
    Product findById(Long id);

    /**
     *
     * @return
     */
    List<Product> findAll();

}
