package com.imnu.SchoolBus.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidDbConfig {
    private Logger logger = LoggerFactory.getLogger(DruidDbConfig.class);

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
   public DruidDataSource druidConfig(){

       return new DruidDataSource();
   }
}