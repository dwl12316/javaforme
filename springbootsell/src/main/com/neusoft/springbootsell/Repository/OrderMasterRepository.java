package src.main.com.neusoft.springbootsell.Repository;

import src.main.com.neusoft.springbootsell.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
