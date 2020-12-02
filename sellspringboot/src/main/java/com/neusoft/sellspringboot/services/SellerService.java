package com.neusoft.sellspringboot.services;


import com.neusoft.sellspringboot.dataobject.SellerInfo;

public interface SellerService {
    void save(SellerInfo s);
    SellerInfo findByOpenIdAndPassword(String openId,String password);
}
