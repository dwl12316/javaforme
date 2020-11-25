package com.neusoft.redbag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LuckyMoneyRepositoryTest {
    //在有springboot时这么创建对象
    @Autowired
    private LuckyMoneyRepository repository;

    @Test
    public void listAll(){
        List<LuckyMoney> list = repository.findAll();
        for(LuckyMoney luckyMoney: list){
            System.out.println(luckyMoney);
        }
    }
    @Test
    public void getId(){
        Optional<LuckyMoney> optional=repository.findById(1);
        System.out.println(optional);
    }
    @Test
    public void save(){
        LuckyMoney luckyMoney=new LuckyMoney();
        luckyMoney.setConsumer("gcf");
        luckyMoney.setMoney(new BigDecimal(50));
        luckyMoney.setProducey("fff");
        repository.save(luckyMoney);
    }
    @Test
    public void delete(){
        repository.deleteById(1);
    }
}
