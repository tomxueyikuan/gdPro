package com.gd.study.service;

import com.gd.study.entity.Elastic;

import java.util.Map;

public interface ElasticService {

    //保存信息及其索引到elasticSearch中
    Boolean save(Elastic elastic,String index) throws Exception;

    //根据索引查询
    Map<String,Object> query(String index) throws Exception;
}
