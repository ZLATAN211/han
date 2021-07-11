package com.easy.han.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

import java.util.concurrent.Callable;
import com.easy.han.entity.Order;
import com.easy.han.entity.CommodityAttributes;
import com.easy.han.entity.Bottle;
import com.easy.han.entity.Water;
import com.easy.han.handler.MqttPublisher;
import com.easy.han.handler.MqttSubscriber;

/**
 * @author zhaohan
 * 执行的任务
 */

public class Implementer implements Callable {

    /**
     * 在这里主要进行订单json解析成为任务json的过程
     * 所有任务都要带着订单id
     * @return String
     * @throws Exception
     */

    public Implementer(String json){

        ParserConfig.getGlobalInstance().setSafeMode(true);
        this.json=json;

    }

    private String json;
    @Override
    public String[] call() throws Exception {

        if (){

            while (){

            }

        }else {
            Order order = JSON.parseObject(json, Order.class);
            int o_id = order.getO_id();
            String s_vals = order.getS_vals();
            CommodityAttributes attributes = JSON.parseObject(s_vals, CommodityAttributes.class);

            short capacity = attributes.getCapacity();
            int num = attributes.getNum();
            Bottle bottle = new Bottle(o_id, capacity, num);
            String bottleTask = (String) JSON.toJSON(bottle);

            String type = attributes.getType();
            long total = attributes.getTotal();
            Water water = new Water(o_id, type, total);
            String waterTask = (String) JSON.toJSON(water);
        }

        String[] task={bottleTask,waterTask};

        return task;

    }

    public static String ack() throws Exception {

        MqttPublisher.publish("ack");
        String order=MqttSubscriber.subscriber();
        return order;

    }

}
