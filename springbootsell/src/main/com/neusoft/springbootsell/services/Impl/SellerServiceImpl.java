package src.main.com.neusoft.springbootsell.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.main.com.neusoft.springbootsell.Repository.SellerInfoRepository;
import src.main.com.neusoft.springbootsell.dataobject.SellerInfo;
import src.main.com.neusoft.springbootsell.enums.ResultEnum;
import src.main.com.neusoft.springbootsell.exception.SellException;
import src.main.com.neusoft.springbootsell.services.SellerService;

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
