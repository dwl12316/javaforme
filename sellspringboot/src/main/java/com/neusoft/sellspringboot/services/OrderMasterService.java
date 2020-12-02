package com.neusoft.sellspringboot.services.Impl;

import com.neusoft.sellspringboot.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface OrderMasterService {
    List<OrderMaster> findAll();

    OrderMaster findById(String orderId);

    Page<OrderMaster> findAll(Pageable pageable);

    void cancel(String orderId);
}
