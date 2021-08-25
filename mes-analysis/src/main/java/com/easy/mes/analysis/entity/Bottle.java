package com.easy.mes.analysis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaohan
 */

@Data
public class Bottle implements Serializable {

    private static final long serialVersionUID = 1251655667158063389L;

    public Bottle(int id,short capacity,int num,int o_id){

        this.capacity=capacity;
        this.num=num;
        this.id=id;
        this.o_id=o_id;

    }

    /**
     * 机器id号
     */
    private int id;
    /**
     * 任务订单号
     */
    private int o_id;
    /**
     * 瓶子容量
     */
    private short capacity;
    /**
     * 瓶子数量
     */
    private int num;
}
