package src.main.com.neusoft.springbootsell.controller;

import com.lly835.bestpay.rest.type.Get;
import com.lly835.bestpay.rest.type.Post;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import src.main.com.neusoft.springbootsell.services.SellerService;

import java.util.Map;

@Controller
@RequestMapping("/seller/user")
public class SellerUserControl {
    @Autowired
    private SellerService service;

    @GetMapping("/save")
    public ModelAndView save(Map<String ,Object> map){
        return new ModelAndView("sellerInfo/index",map);
    }

//    @GetMapping("/login")
//    public ModelAndView login(){
//
//    }
}
