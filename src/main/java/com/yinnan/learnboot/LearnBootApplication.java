package com.yinnan.learnboot;

import com.yinnan.learnboot.config.WebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LearnBootApplication {

    public static void main(String[] args) {
//        SpringApplication.run(LearnBootApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(LearnBootApplication.class, args);
        context.getBean(WebConfiguration.class).show();
        System.out.println("Hello");
    }
}
