package com.yinnan.learnboot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yinnan
 * Date: 2018/9/29
 * Time: 16:25
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@Slf4j
@Configuration
public class BeanConfiguration {
    @Bean
    @Profile("dev")
    public Runnable test1() {
        log.info("开发环境使用的 Bean");
        return () -> {};
    }

    @Bean
    @Profile("test")
    public Runnable test2() {
        log.info("测试环境使用的 Bean");
        return () -> {};
    }

    @Bean
    @Profile("ol")
    public Runnable test3() {
        log.info("生成环境使用的 Bean");
        return () -> {};
    }
}
