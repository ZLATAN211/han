package com.example.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
/**
 *
 * @author zhaohan
 * @since 2021-02-17
 */

@Configuration
@MapperScan("com/easy/mes/analysis/mapper")
public class AssemblyLineConfig {
}
