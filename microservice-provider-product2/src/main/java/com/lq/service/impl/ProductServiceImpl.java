package com.lq.service.impl;

import com.lq.mapper.IProductMapper;
import com.lq.service.IProductService;
import com.lq.vo.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 鸟欲高飞先振翅
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liqian
 * @Date: 2019-03-17
 * @Time: 10:56
 * 人求上进先读书
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Resource
    IProductMapper productMapper;

    @Override
    public Product get(long id) {
        return productMapper.findById(id);
    }

    @Override
    public boolean add(Product product) {
        return productMapper.create(product);
    }

    @Override
    public List<Product> list() {
        return productMapper.findAll();
    }
}
