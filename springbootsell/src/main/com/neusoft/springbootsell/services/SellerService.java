package src.main.com.neusoft.springbootsell.services;

import src.main.com.neusoft.springbootsell.dataobject.SellerInfo;

public interface SellerService {
    void save(SellerInfo s);
    SellerInfo findByOpenIdAndPassword(String openId,String password);
}
