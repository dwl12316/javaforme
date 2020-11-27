package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.ProductCategory;
import com.neusoft.springbootsell.services.Impl.CategoryServiceImpl;
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
    }
}
