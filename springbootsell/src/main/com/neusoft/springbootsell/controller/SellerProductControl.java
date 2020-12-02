package src.main.com.neusoft.springbootsell.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import src.main.com.neusoft.springbootsell.dataobject.ProductCategory;
import src.main.com.neusoft.springbootsell.dataobject.ProductInfo;
import src.main.com.neusoft.springbootsell.enums.ProductStatus;
import src.main.com.neusoft.springbootsell.enums.ResultEnum;
import src.main.com.neusoft.springbootsell.exception.SellException;
import src.main.com.neusoft.springbootsell.form.ProductForm;
import src.main.com.neusoft.springbootsell.services.CategoryService;
import src.main.com.neusoft.springbootsell.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import src.main.com.neusoft.springbootsell.utils.KeyUtil;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/product")
public class SellerProductControl {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "5") Integer size,
                             Map<String,Object> map){
        PageRequest pageRequest= new PageRequest(page-1,size);
        Page<ProductInfo> productInfos=productService.findAll(pageRequest);
        map.put("productInfoPage",productInfos);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("product/list",map);
    }
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                              Map<String, Object> map){
        if(!StringUtils.isEmpty(productId)){
            // 修改
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo", productInfo);
        }
        // 查询类目并且进行返回
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("product/index");
    }
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map
    ){
        if (bindingResult.hasErrors()){
            // 返回错误页面
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            if(!StringUtils.isEmpty(form.getProductId())) {
                map.put("url", "/seller/product/index?productId="+form.getProductId());
            }else {
                map.put("url", "/seller/product/index");
            }
            return new ModelAndView("common/error", map);
        }

        ProductInfo productInfo = new ProductInfo();
        try {
            //        productInfo.setProductName(form.getProductName());
            if (StringUtils.isEmpty(form.getProductId())){
                form.setProductId(KeyUtil.genUniqueKey());
            }
            BeanUtils.copyProperties(form, productInfo);
            productService.save(productInfo);

        }catch (SellException exception){
            map.put("msg", exception.getMessage());
            if(!StringUtils.isEmpty(form.getProductId())) {
                map.put("url", "/seller/product/index?productId="+form.getProductId());
            }else {
                map.put("url", "/seller/product/index");
            }
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/product/list");
        return new ModelAndView("common/success", map);
    }
    @PostMapping("/put")
    public ModelAndView UpandDown(@RequestParam(value = "productId") String productId, Map<String, Object> map){
        if(productService.findOne(productId)==null){
                map.put("msg", ResultEnum.PRODUCT_NOT_EXIST);
                map.put("url", "/seller/product/list");
                return new ModelAndView("common/error", map);
        }
        try {
            if (productService.findOne(productId).getProductStatus().equals(ProductStatus.UP.getCode())) {
                productService.offSale(productId);
            } else {
                productService.onSale(productId);
            }
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url", "/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}
