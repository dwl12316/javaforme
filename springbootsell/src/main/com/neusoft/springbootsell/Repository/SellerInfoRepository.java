package src.main.com.neusoft.springbootsell.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import src.main.com.neusoft.springbootsell.dataobject.SellerInfo;

public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {
    SellerInfo findByOpenid(String openId);
    SellerInfo findByOpenidAndPassword(String openId,String password);
}
