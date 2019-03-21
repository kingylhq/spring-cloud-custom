package com.lq.vo;

import java.io.Serializable;

/**
 * 鸟欲高飞先振翅
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liqian
 * @Date: 2019-03-17
 * @Time: 10:31
 * 人求上进先读书
 */
public class Product implements Serializable {

    private Integer id;

    private String productName;

    private String productDesc;

    public Product() {
    }

    public Product(Integer id, String productName, String productDesc) {
        this.id = id;
        this.productName = productName;
        this.productDesc = productDesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                '}';
    }
}
