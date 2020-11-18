package com.gd.study.service;

import com.gd.study.entity.ProductInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductInfoRepository extends ElasticsearchRepository<ProductInfo,String> {
}
