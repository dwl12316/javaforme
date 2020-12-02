package com.neusoft.sellspringboot.controller;

import com.lly835.bestpay.rest.type.Get;
import com.lly835.bestpay.rest.type.Post;
import com.neusoft.sellspringboot.dataobject.SellerInfo;
import com.neusoft.sellspringboot.exception.SellException;
import com.neusoft.sellspringboot.services.SellerService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import src.main.com.neusoft.springbootsell.form.SellerForm;


import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/seller/user")
public class SellerUserControl {
    @Autowired
    private SellerService service;

    @GetMapping("/index")
    public ModelAndView index(Map<String, Object> map) {
        return new ModelAndView("sellerInfo/index", map);
    }

    @GetMapping("/regist")
    public ModelAndView regist(Map<String, Object> map) {
        return new ModelAndView("sellerInfo/registration", map);
    }

    @PostMapping("save")
    public ModelAndView save(@Valid SellerForm form, BindingResult bindingResult, Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            // 返回错误页面
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/seller/user/regist");
            return new ModelAndView("common/error", map);
        }
        if (!form.getOnepassword().equals(form.getSecpassword())) {
            map.put("msg", "两次密码不一致");
            map.put("url", "/seller/user/regist");
            return new ModelAndView("common/error", map);
        }
        SellerInfo sellerInfo = new SellerInfo();
        try {
            sellerInfo.setOpenid(form.getOpenid());
            sellerInfo.setUsername(form.getUsername());
            sellerInfo.setPassword(form.getOnepassword());
            service.save(sellerInfo);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/seller/user/regist");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/user/index");
        return new ModelAndView("common/success", map);
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid SellerForm form, BindingResult bindingResult, Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            // 返回错误页面
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/seller/user/index");
            return new ModelAndView("common/error", map);
        }
        try {
            service.findByOpenIdAndPassword(form.getOpenid(), form.getOnepassword());
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/seller/user/index");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "");
        return new ModelAndView("common/success", map);
    }
}
