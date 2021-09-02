package com.easy.mes.verification;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author zhaohan
 */

@MapperScan("com.easy.mes.verification.mapper")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AssemblyLineApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssemblyLineApplication.class, args);
    }

}
