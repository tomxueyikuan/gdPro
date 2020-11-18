package com.gd.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.gd.study.entity.Elastic;
import com.gd.study.service.ElasticService;
import lombok.AllArgsConstructor;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class ElasticServiceImpl implements ElasticService {

    @Resource
    private RestHighLevelClient restHighLevelClient;

    private final String indexName = "el1";

    @Override
    public Boolean save(Elastic elastic, String index) throws Exception {
        String elJson = JSON.toJSONString(elastic);
        IndexRequest indexRequest = new IndexRequest(indexName).id(index).source(elJson, XContentType.JSON);
        IndexResponse response=restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        if(null!=response){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Map<String, Object> query(String index) throws Exception {
        GetRequest request = new GetRequest(indexName, index);
        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        return response.getSource();
    }
}
