package com.neusoft.sellspringboot.Repository;


import com.neusoft.sellspringboot.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
}
