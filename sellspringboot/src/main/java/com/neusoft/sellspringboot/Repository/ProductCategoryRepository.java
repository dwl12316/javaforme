package com.neusoft.sellspringboot.Repository;


import com.neusoft.sellspringboot.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findByCategoryTypeIn (List<Integer> CategoryType);
}
