package com.neusoft.redbag;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * LuckyMoney 是数据库表中字段一一对应的实体集
 * JavaBean格式
 */
@Entity
//指定该类是实体类
@Data
public class LuckyMoney {
    @Id
    //代表主键
    @GeneratedValue
    private Integer id;
    // 红包金额
    private BigDecimal money;
    // 发红包的人
    private String producey;
    // 收红包的人
    private String consumer;

    public LuckyMoney() {
    }

}
