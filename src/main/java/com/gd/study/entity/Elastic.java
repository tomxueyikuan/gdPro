package com.gd.study.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 使用RestHighLevelClient操作的elasticSearch的实体
 */
@Data
@Builder
public class Elastic implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String remark;
}
