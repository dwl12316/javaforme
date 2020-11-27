package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.ProductCategory;
import com.neusoft.springbootsell.services.Impl.CategoryServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findtype(){
        List<ProductCategory> list=categoryService.findByCategoryTypeIn(Arrays.asList(2,3,9));
        for (ProductCategory pro: list) {
            System.out.println(pro);
        }
    }

    @Test
    public void save(){
        ProductCategory category = new ProductCategory("炸鸡汉堡", 3);
        ProductCategory productCategory = categoryService.save(category);
        Assert.assertNotNull(productCategory);

    }
}
