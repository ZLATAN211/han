package com.easy.han.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import com.easy.han.entity.*;
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

        ArrayList<String> tops = new ArrayList<>();

        Order order1 = JSON.parseObject(json, Order.class);
        String s_valss = order1.getS_vals();
        CommodityAttributes attributess = JSON.parseObject(s_valss, CommodityAttributes.class);
        int num1=attributess.getNum();

        int surplus=num1;

        while (surplus>0) {

            String returns = ack();

            Returns returns1 = JSON.parseObject(returns, Returns.class);
            int total1 = returns1.getTotal();
            int busy = returns1.getBusy();
            int free = total1 - busy;

            if (free < surplus) {

                int o_id1 = order1.getO_id();
                short capacity1 = attributess.getCapacity();
                Bottle bottle = new Bottle(o_id1, capacity1, free);
                String bottleTask1 = (String) JSON.toJSON(bottle);

                String type1 = attributess.getType();
                int total2 = free * capacity1;
                Water water = new Water(o_id1, type1, total2);
                String waterTask1 = (String) JSON.toJSON(water);

                tops.add(bottleTask1);
                tops.add(waterTask1);

                surplus = surplus - free;

            } else {

                int o_id = order1.getO_id();

                short capacity = attributess.getCapacity();
                Bottle bottle = new Bottle(o_id, capacity, surplus);
                String bottleTask = (String) JSON.toJSON(bottle);

                String type = attributess.getType();
                Water water = new Water(o_id, type, capacity*surplus);
                String waterTask = (String) JSON.toJSON(water);

                tops.add(bottleTask);
                tops.add(waterTask);

                surplus=0;

            }

        }

        String[] task = new String[tops.size()];

        for (int i=0;i<=tops.size();i++){

            task[i]=tops.get(i);

        }

        return task;

    }

    public static String ack() throws Exception {

        MqttPublisher.publish("ack");
        String order=MqttSubscriber.subscriber();
        return order;

    }

}

