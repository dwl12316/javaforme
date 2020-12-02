package com.neusoft.sellspringboot.services.Impl;

import com.neusoft.sellspringboot.Repository.OrderMasterRepository;
import com.neusoft.sellspringboot.dataobject.OrderMaster;
import com.neusoft.sellspringboot.enums.OrderStatusEnum;
import com.neusoft.sellspringboot.enums.ResultEnum;
import com.neusoft.sellspringboot.exception.SellException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderMasterServiceImpl implements com.neusoft.sellspringboot.services.Impl.OrderMasterService {
    @Autowired
    private OrderMasterRepository repository;

    @Override
    public List<OrderMaster> findAll() {
        return repository.findAll();
    }

    @Override
    public OrderMaster findById(String orderId) {
        return repository.findOne(orderId);
    }

    @Override
    public Page<OrderMaster> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void cancel(String orderId) {
        OrderMaster orderMaster=repository.findOne(orderId);
        if(orderMaster==null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if(orderMaster.getOrderStatus().equals(OrderStatusEnum.FINISHD.getCode())||orderMaster.getOrderStatus().equals(OrderStatusEnum.CANCEL.getCode())){
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        orderMaster.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        repository.save(orderMaster);
    }
}
