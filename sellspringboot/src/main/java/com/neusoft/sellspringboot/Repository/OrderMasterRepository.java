package com.neusoft.sellspringboot.Repository;


import com.neusoft.sellspringboot.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
