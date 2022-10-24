package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class Test1Appliocation {
    public static void main(String[] args) {
        try {
            SpringApplication.run(Test1Appliocation.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
