package com.yinnan.learnboot;

import com.yinnan.learnboot.config.WebConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class LearnBootApplication {


    public static void main(String[] args) {
//        SpringApplication.run(LearnBootApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(LearnBootApplication.class, args);
        context.getBean(WebConfiguration.class).show();
        log.info("Hello");
    }
}
