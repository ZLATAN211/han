package com.easy.mes.analysis;

import com.easy.mes.analysis.handler.NettyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Autowired
    public NettyClient client;

    @Override
    public void run(String... args) throws Exception {
        client.connect(8888,"127.0.0.1");
    }

}
