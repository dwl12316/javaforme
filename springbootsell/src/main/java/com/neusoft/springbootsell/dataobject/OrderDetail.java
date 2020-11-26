package com.neusoft.springbootsell.dataobject;

import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 订单详情
 */
@Data
public class OrderDetail {
    @Id
    private String dateilId;
    /**
     * 订单Id
     */
    private String orderId;
    /**
     * 商品Id
     */
    private String productId;
    /**
     * 商品名
     */
    private String productName;
    /**
     * 商品价格
     */
    private BigDecimal productPrice;
    /**
     * 商品数
     */
    private Integer productQuantity;
    /**
     * 商品图
     */
    private String productIcon;
}
