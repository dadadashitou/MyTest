package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
@EnableAsync
public class TestAppliocation {
    public static void main(String[] args) {
        try {
            SpringApplication.run(TestAppliocation.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
