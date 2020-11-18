package com.gd.study.service.impl;

import com.gd.study.service.BaseSearchService;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.DeleteQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * elasticSearch搜索
 * @param <T>
 */
public class BaseSearchServiceImpl <T> implements BaseSearchService<T> {

    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public List<T> query(String keyword, Class<T> clazz) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(new QueryStringQueryBuilder(keyword))
                .withSort(SortBuilders.scoreSort().order(SortOrder.DESC))
                // .withSort(new FieldSortBuilder("createTime").order(SortOrder.DESC))
                .build();
        // 使用ElasticsearchRestTemplate进行复杂查询
        return null;
    }

    @Override
    public List<Map<String, Object>> queryHit(String keyword, String indexName, String... fieldNames) {
        return null;
    }

    @Override
    public Page<Map<String, Object>> queryHitByPage(int pageNo, int pageSize, String keyword, String indexName, String... fieldNames) {
        return null;
    }

    @Override
    public Boolean deleteIndex(String indexName) {
        return null;
    }
}
