package com.easy.han.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaohan
 * 商品销售属性
 */

@Data
public class CommodityAttributes implements Serializable {

    private static final long serialVersionUID = 3290614051092242511L;

    /**
     * 酒水种类
     */
    private String type;
    /**
     * 瓶子容量
     */
    private short capacity;
    /**
     *个数
     */
    private int num;
    /**
     * 酒水总量
     */
    private long total;

}

