package com.neusoft.sellspringboot.services.Impl;

import com.neusoft.sellspringboot.Repository.SellerInfoRepository;
import com.neusoft.sellspringboot.dataobject.SellerInfo;
import com.neusoft.sellspringboot.enums.ResultEnum;
import com.neusoft.sellspringboot.exception.SellException;
import com.neusoft.sellspringboot.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerInfoRepository repository;

    @Override
    public void save(SellerInfo s) {
        if(repository.findByOpenid(s.getOpenid())!=null){
            throw new SellException(ResultEnum.OPENID_ERROR);
        }else {
            repository.save(s);
        }
    }

    @Override
    public SellerInfo findByOpenIdAndPassword(String openId, String password) {
        if(repository.findByOpenidAndPassword(openId,password)==null){
            throw new SellException(ResultEnum.LOGINING_ERROR);
        }
        return repository.findByOpenidAndPassword(openId,password);
    }
}
