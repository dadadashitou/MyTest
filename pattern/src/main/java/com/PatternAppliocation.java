package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

//exclude= DataSourceAutoConfiguration.class 自动注入数据源,不用配置数据库就可以启动项目
@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
@EnableAsync
public class PatternAppliocation {
    public static void main(String[] args) {
        try {
            SpringApplication.run(PatternAppliocation.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
