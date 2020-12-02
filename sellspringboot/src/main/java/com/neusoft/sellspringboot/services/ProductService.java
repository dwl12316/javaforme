package com.neusoft.sellspringboot.services;


import com.neusoft.sellspringboot.dataobject.ProductInfo;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProductService {
    //查询一个商品
    ProductInfo findOne(String productId);
    //查询所有商品
    List<ProductInfo> findUpAll();
    //分页查询所有商品
    Page<ProductInfo> findAll(Pageable pageable);
    //新增商品
    ProductInfo save(ProductInfo productInfo);
    //上架商品
    void onSale(String productId);
    //下架商品
    void offSale(String productId);
    //库存
    // 加库存
    void increaseStock(String productId);
    // 减库存
    void decreaseStock(String productId);


}
