package com.yinnan.learnboot.config;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yinnan
 * Date: 2018/9/30
 * Time: 09:48
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@Slf4j
@Configuration
public class WebConfiguration {
    @Value("${ds.userName}")
    private String userName;

    @Autowired
    private Environment environment;

    public void show() {
        log.info("ds.userName ={}" , this.userName);
        log.info("ds.password ={}" , this.environment.getProperty("ds.password"));
    }
}
