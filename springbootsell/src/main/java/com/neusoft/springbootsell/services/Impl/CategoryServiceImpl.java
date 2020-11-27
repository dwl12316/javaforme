package com.neusoft.springbootsell.services.Impl;

import com.neusoft.springbootsell.Repository.ProductCategoryRepository;
import com.neusoft.springbootsell.dataobject.ProductCategory;
import com.neusoft.springbootsell.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository repository;
    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        List<ProductCategory> list=repository.findAll();
        return list;
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
//        List<ProductCategory> list=new ArrayList<>();
//        List<ProductCategory> list1=repository.findAll();
//        for (Integer type:categoryTypeList) {
//            for (ProductCategory productCategory:list1) {
//                if (productCategory.getCategoryType().equals(type)){
//                    list.add(productCategory);
//                }
//            }
//        }
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
