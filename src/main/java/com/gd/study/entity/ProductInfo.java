package com.gd.study.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 *使用org.springframework.data.elasticsearch.annotations注解的实体
 * 注解@Document（
 *indexName：索引的名字
 * type：文档类型名称
 * shards：分片数，默认5
 * replicas：副本数量，默认1
 * createIndex：是否创建索引（索引不存在的情况下），默认true
 * useServerConfiguration：创建索引的时候，是否使用服务端的配置，默认为false
 * refreshInterval：刷新频率即配置一个文档新增后多久可以查询到，默认为1秒
 * indexStoreType：索引存储方式，默认为fs文件存储类型
 * ）
 * 注解@Field
 * ormat：时间格式，默认无，存储毫秒数。具体参数可参照org.springframework.data.elasticsearch.annotations.DateFormat
 * index：是否进行分词，默认为true
 * searchAnalyzer：指定字段搜索时使用的分词器
 * analyzer：指定字段建立索引时所使用的分词器
 * ignoreFields：指定忽略字段
 * type：指定字段类型，具体可参照org.springframework.data.elasticsearch.annotationsFieldType
 *
 */
@Data
@Document(indexName = "product")
public class ProductInfo {

    @Id
    private String id;

    private String name;

    private String address;
}
