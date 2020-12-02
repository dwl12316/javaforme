package src.main.com.neusoft.springbootsell.Repository;

import src.main.com.neusoft.springbootsell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductStatus(Integer ProductStatus);
}
