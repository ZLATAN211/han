package com.easy.han;

import com.easy.han.handler.MqttPublisher;
import com.easy.han.handler.MqttSubscriber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HanApplication {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(HanApplication.class, args);
        MqttPublisher.publisher(MqttSubscriber.subscriber());

    }

}

