package com.neusoft.sellspringboot.services;



import com.neusoft.sellspringboot.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {
    public ProductCategory findOne(Integer categoryId);

    public List<ProductCategory> findAll();

    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    public ProductCategory save(ProductCategory productCategory);

    public void delete(Integer categoryId);
}
