package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.ProductInfo;
import com.neusoft.springbootsell.services.Impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findall(){
        List<ProductInfo> list=productService.findUpAll();
        for (ProductInfo pro: list) {
            System.out.println(pro);
        }
    }
}
