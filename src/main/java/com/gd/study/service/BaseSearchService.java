package com.gd.study.service;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface BaseSearchService<T> {

    /**
     * 查询
     * @param keyword
     * @param clazz
     * @return
     */
    List<T> query(String keyword, Class<T> clazz);

    /**
     * 搜索高亮显示
     * @param keyword
     * @param indexName
     * @param fieldNames
     * @return
     */
    List<Map<String,Object>> queryHit(String keyword, String indexName, String ... fieldNames);

    /**
     * 搜索高亮显示，返回分页数据
     * @param pageNo
     * @param pageSize
     * @param keyword
     * @param indexName
     * @param fieldNames
     * @return
     */
    Page<Map<String,Object>> queryHitByPage(int pageNo, int pageSize, String keyword, String indexName, String ... fieldNames);

    /**
     * 根据索引删除
     * @param indexName
     */
    Boolean deleteIndex(String indexName);
}
