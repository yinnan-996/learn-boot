package com.yinnan.learnboot.config;

import com.yinnan.learnboot.driverManager.EncryptedDriverManagerDataSource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yinnan
 * Date: 2018/9/30
 * Time: 11:47
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@Slf4j
@Configuration
@PropertySource("classpath:application-dataSource.properties")
@Data
@ComponentScan
public class DataSourceConfig {

    @Bean(name = "examSystem")
    @Qualifier("examSystem")
    @ConfigurationProperties(prefix="spring.datasource.exam-system")
    public DataSource getMyDataSource(){
        return new EncryptedDriverManagerDataSource();
    }

    @Bean(name = "sys")
    @Qualifier("sys")
    @ConfigurationProperties(prefix="spring.datasource.sys")
    public DataSource dataSource() {
        return new EncryptedDriverManagerDataSource();
    }


}
