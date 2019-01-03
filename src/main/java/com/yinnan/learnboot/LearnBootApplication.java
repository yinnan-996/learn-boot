package com.yinnan.learnboot;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.yinnan.learnboot.config.WebConfigurationTest;
import com.yinnan.learnboot.mybean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * boot启动入口
 * @author yinnan
 */
@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(WebConfigurationTest.class)
@EnableEncryptableProperties
@PropertySource(name = "EncryptedProperties", value = {"classpath:application-dataSource.properties","classpath:application.properties"})
@ImportResource({"classpath*:TestBean.xml"})
public class LearnBootApplication {

    @Autowired
    WebConfigurationTest webConfigurationTest;

    @Autowired @Qualifier("commonMap")
    private Map<String, String> commonMap;



    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("TestBean.xml");
        User user = (User) applicationContext.getBean("testBean");
        log.info("user ={}",user);
        SpringApplication.run(LearnBootApplication.class, args);
    }

}
