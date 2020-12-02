package com.neusoft.sellspringboot.Repository;


import com.neusoft.sellspringboot.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductStatus(Integer ProductStatus);
}
