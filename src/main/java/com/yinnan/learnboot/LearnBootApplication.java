package com.yinnan.learnboot;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.yinnan.learnboot.config.GetConfiguration;
import com.yinnan.learnboot.config.WebConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(WebConfiguration.class)
@EnableEncryptableProperties
@PropertySource(name = "EncryptedProperties", value = {"classpath:application-dataSource.properties","classpath:application.properties"})
public class LearnBootApplication {

    @Autowired
    WebConfiguration webConfiguration;

    @Autowired @Qualifier("commonMap")
    protected Map<String, String> commonMap;

    public static void main(String[] args) {
        SpringApplication.run(LearnBootApplication.class, args);
        log.info("config={}",GetConfiguration.getConfig("application-dataSource"));
        log.info("Hello");
    }

    public void showWebConfig(){
        log.info("username={}",webConfiguration.getUserName());
    }
}
