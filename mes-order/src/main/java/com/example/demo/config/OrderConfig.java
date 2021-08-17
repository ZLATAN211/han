package com.example.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author LiZiHan
 * @since 2021-02-21
 */
@Configuration
@MapperScan("com/example/demo/mapper")
public class OrderConfig {

}
