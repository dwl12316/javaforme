package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.Repository.OrderMasterRepository;
import com.neusoft.springbootsell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;
    private final String OPENID="11122333";

    @Test
    public void save(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("小丸子");
        orderMaster.setBuyerPhone("139999999999");
        orderMaster.setBuyerAddress("江科大南门");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.9));

        OrderMaster result = repository.save(orderMaster);
//        System.out.println(master);
        //分析是不是null
        Assert.assertNotNull(result);
    }
}
