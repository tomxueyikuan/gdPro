package com.gd.study.controller;

import com.gd.study.entity.Elastic;
import com.gd.study.entity.ProductInfo;
import com.gd.study.service.ElasticService;
import com.gd.study.service.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * 使用RestHighLevelClient 进行elasticSearch的保存和查询
 */
@RequestMapping("/elastic")
@RestController
public class ElasticController {

    @Resource
    private ElasticService elasticService;

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @RequestMapping("/queryEl")
    public Map<String,Object> testEl(){
        Map<String, Object> query = new HashMap<>();
        try{
            Elastic elastic = Elastic.builder()
                    .id("1002")
                    .name("demo")
                    .remark("测试")
                    .build();
            String indexId = "test001";
            elasticService.save(elastic,indexId);

            Elastic elastic1 = Elastic.builder()
                    .id("1003")
                    .name("demo2"+System.currentTimeMillis())
                    .remark("测试1")
                    .build();
            indexId = "test002";
            elasticService.save(elastic1, indexId);

            query = elasticService.query(indexId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return query;
    }


    @RequestMapping("/queryEl1")
    public String testEl2(){
        String optional = productInfoRepository.findById("test002").toString();
        return optional;
    }

    @RequestMapping("/saveInfo")
    public String saveInfo(){
        List<ProductInfo> list =new ArrayList<>();
        for(int i = 0;i<=3;i++){
            ProductInfo productInfo =  new ProductInfo();
            productInfo.setId("1000"+i);
            productInfo.setName("wang"+i);
            productInfo.setAddress("xian"+i);
            list.add(productInfo);
        }
        productInfoRepository.saveAll(list);
        return "success";
    }

    @GetMapping("/all")
    public Iterable<ProductInfo> all(){
        Iterable<ProductInfo> infoIterable = productInfoRepository.findAll();
        return infoIterable;
    }

}
