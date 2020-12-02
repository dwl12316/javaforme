package src.main.com.neusoft.springbootsell.services.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import src.main.com.neusoft.springbootsell.Repository.OrderMasterRepository;
import src.main.com.neusoft.springbootsell.dataobject.OrderMaster;
import src.main.com.neusoft.springbootsell.enums.OrderStatusEnum;
import src.main.com.neusoft.springbootsell.enums.ResultEnum;
import src.main.com.neusoft.springbootsell.exception.SellException;
import src.main.com.neusoft.springbootsell.services.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderMasterServiceImpl implements OrderMasterService {
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
