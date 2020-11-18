package com.gd.study.config;

import lombok.Data;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

/**
 * Elasticsearch配置
 */
@Data
@Configuration
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

    @Value("${elasticSearch.host.port}")
    private String hostAndPort ;
    @Value("${elasticSearch.connectionTimeout}")
    private Long connectTimeout;
    @Value("${elasticSearch.socketTimeout}")
    private Long socketTimeout;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(hostAndPort)
                .withConnectTimeout(connectTimeout)
                .withSocketTimeout(socketTimeout)
                .build();
        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    public ElasticsearchRestTemplate restTemplate() throws Exception {
        return new ElasticsearchRestTemplate(elasticsearchClient());
    }
}
