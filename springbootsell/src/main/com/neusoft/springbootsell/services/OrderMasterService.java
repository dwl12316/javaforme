package src.main.com.neusoft.springbootsell.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import src.main.com.neusoft.springbootsell.dataobject.OrderMaster;
import src.main.com.neusoft.springbootsell.dataobject.ProductInfo;

import java.util.List;

public interface OrderMasterService {
    List<OrderMaster> findAll();

    OrderMaster findById(String orderId);

    Page<OrderMaster> findAll(Pageable pageable);

    void cancel(String orderId);
}
