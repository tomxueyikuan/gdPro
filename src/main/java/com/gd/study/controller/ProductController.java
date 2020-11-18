package com.gd.study.controller;

import com.gd.study.product.Product;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Resource
    private Product product;

    @RequestMapping("/productInfo")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public void productInfo(){
        product.send("demo"+System.currentTimeMillis());
    }

    @RequestMapping("/test")
    public String test(){
        return "test"+System.currentTimeMillis();
    }
}
