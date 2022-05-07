package com.ali.vo;

import lombok.Data;

import java.util.Map;

/**
 * 对应柱状图数据
 */
@Data
public class PieVO {
    private Integer value;
    private Map<String, String> itemStyle;
    private String name;
}
