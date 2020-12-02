package com.neusoft.sellspringboot.controller;

import com.neusoft.sellspringboot.dataobject.ProductCategory;
import com.neusoft.sellspringboot.exception.SellException;
import com.neusoft.sellspringboot.services.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import src.main.com.neusoft.springbootsell.form.CategoryForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/category")
public class SellerCategoryControl {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list(Map<String,Object> map){
        List<ProductCategory> list=categoryService.findAll();
        map.put("categorylist",list);
        return new ModelAndView("category/list",map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId",required = false) Integer categoryId, Map<String, Object> map){
            if(categoryId!=null){
                // 修改
                ProductCategory category = categoryService.findOne(categoryId);
                map.put("category", category);
            }
        return new ModelAndView("category/index");
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form, BindingResult bindingResult, Map<String, Object> map){
        if (bindingResult.hasErrors()){
            // 返回错误页面
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            if(form.getCategoryId()!=null) {
                map.put("url", "/seller/category/index?categoryId="+form.getCategoryId());
            }else {
                map.put("url", "/seller/category/index");
            }
            return new ModelAndView("common/error", map);
        }

        ProductCategory category = new ProductCategory();
        try {
            BeanUtils.copyProperties(form, category);
            categoryService.save(category);

        }catch (SellException exception){
            map.put("msg", exception.getMessage());
            if(form.getCategoryId()!=null) {
                map.put("url", "/seller/category/index?categoryId="+form.getCategoryId());
            }else {
                map.put("url", "/seller/category/index");
            }
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/category/list");
        return new ModelAndView("common/success", map);
    }
    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam(value = "categoryId") Integer categoryId,Map<String, Object> map){
        if(categoryService.findOne(categoryId)==null){
            map.put("msg","类目不存在");
            map.put("url", "/seller/category/list");
            return new ModelAndView("common/error", map);
        }
        categoryService.delete(categoryId);
        map.put("url", "/seller/category/list");
        return new ModelAndView("common/success", map);
    }
}
