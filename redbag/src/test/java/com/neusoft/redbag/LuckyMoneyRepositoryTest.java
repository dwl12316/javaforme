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
        luckyMoney.setConsumer("gdf");
//        luckyMoney.setMoney(new BigDecimal(50));
//        luckyMoney.setProducer("ff");
        repository.save(luckyMoney);
    }
    @Test
    public void delete(){
        repository.deleteById(4);
    }
    @Test
    public void update(){
        LuckyMoney luckyMoney = new LuckyMoney();
        luckyMoney.setConsumer("王五");
        luckyMoney.setMoney(new BigDecimal(21));
        luckyMoney.setProducer("赵六");
        luckyMoney.setId(2);
        repository.save(luckyMoney);
    }
}
