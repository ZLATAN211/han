package com.easy.han.entity;

import lombok.Data;

/**
 * @author zhaohan
 */

@Data
public class Returns {

    /**
     * 回报标志
     */
    private String ack;

    /**
     * 工厂的总流水线数量
     */
    private int total;

    /**
     * 工厂的繁忙流水线数量
     */
    private int busy;

}

