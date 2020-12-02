package src.main.com.neusoft.springbootsell.Repository;

import src.main.com.neusoft.springbootsell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
}
