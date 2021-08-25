package com.easy.mes.analysis.service;

import com.alibaba.fastjson.JSON;
import com.easy.mes.analysis.entity.*;
import com.easy.mes.analysis.handler.MqttPublisher;
import com.easy.mes.analysis.handler.MqttSubscriber;
import mesanalysis.demo.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Implementer implements Callable {

    public Implementer(String json){

        this.json=json;

    }

    private String json;

    @Override
    public String[] call() throws Exception {

        ArrayList<String> bot=new ArrayList<>();

        Order order=JSON.parseObject(json,Order.class);
        String s_vals=order.getS_vals();
        int productionTime=order.getProductionTime();
        CommodityAttributes attributes=JSON.parseObject(s_vals, CommodityAttributes.class);
        long total=attributes.getTotal();
        int num=attributes.getNum();
        String type=attributes.getType();

        int surplus=num;

        while (surplus>0){

            String returns=ack(Type.bottle);
            List<Returns> list=JSON.parseArray(returns,Returns.class);

            Returns returns1=JSON.parseObject(returns, Returns.class);
            //获得产能
            int capacity=returns1.getCapacity();
            int yield=capacity*productionTime;
            surplus=surplus-yield;

            if (surplus>0){

                Bottle bottle=new Bottle(returns1.getId(),attributes.getCapacity(),yield,order.getO_id());
                String json=(String) JSON.toJSON(bottle);
                bot.add(json);

            }else {

                Bottle bottle=new Bottle(returns1.getId(),attributes.getCapacity(),surplus,order.getO_id());
                String json=(String)JSON.toJSON(bottle);
                bot.add(json);

            }

        }


        return null;

    }

    public static String ack(String type) throws Exception {

        MqttPublisher.publish(type);
        String returns= MqttSubscriber.subscriber();
        return returns;

    }

}

