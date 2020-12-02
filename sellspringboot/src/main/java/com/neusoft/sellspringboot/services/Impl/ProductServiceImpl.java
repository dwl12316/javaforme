package com.neusoft.sellspringboot.services.Impl;


import com.neusoft.sellspringboot.Repository.ProductInfoRepository;
import com.neusoft.sellspringboot.dataobject.ProductInfo;
import com.neusoft.sellspringboot.enums.ProductStatus;
import com.neusoft.sellspringboot.enums.ResultEnum;
import com.neusoft.sellspringboot.exception.SellException;
import com.neusoft.sellspringboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatus.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public void onSale(String productId) {
        ProductInfo productInfo=repository.findOne(productId);
        if(productInfo == null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if(productInfo.getProductStatus().equals(ProductStatus.UP.getCode())){
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        productInfo.setProductStatus(ProductStatus.UP.getCode());
        repository.save(productInfo);
    }

    @Override
    public void offSale(String productId) {
        ProductInfo productInfo=repository.findOne(productId);
        if(productInfo == null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if(productInfo.getProductStatus().equals(ProductStatus.DOWN.getCode())){
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        productInfo.setProductStatus(ProductStatus.DOWN.getCode());
        repository.save(productInfo);
    }

    @Override
    public void increaseStock(String productId) {

    }

    @Override
    public void decreaseStock(String productId) {

    }
}
