package com.neusoft.sellspringboot.Repository;
import com.neusoft.sellspringboot.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {
    SellerInfo findByOpenid(String openId);
    SellerInfo findByOpenidAndPassword(String openId,String password);
}
