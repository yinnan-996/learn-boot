package com.yinnan.learnboot.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yinnan
 * Date: 2018/9/30
 * Time: 11:59
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceConfigTest {

    @Resource(name = "examSystem")
    private DataSource examSystem;

    @Resource(name = "sys")
    private DataSource sys;

    @Test
    public void contextLoads() {
        //执行SQL,输出查到的数据
        JdbcTemplate jdbcTemplate = new JdbcTemplate(examSystem);
        List<?> resultList = jdbcTemplate.queryForList("select * from flyway_schema_history");
        log.info("result={}", JSON.toJSONString(resultList));

        //执行SQL,输出查到的数据
        JdbcTemplate jdbcTemplate2 = new JdbcTemplate(sys);
        List<?> resultList2 = jdbcTemplate2.queryForList("select * from sys_config");
        log.info("result={}", JSON.toJSONString(resultList2));
    }

    @Autowired
    DataSourceProperties dataSourceProperties;

    @Autowired
    ApplicationContext applicationContext;
    @Test
    public void contextLoad() {
        // 获取配置的数据源
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        // 查看配置数据源信息
        System.out.println(dataSource);
        System.out.println(dataSource.getClass().getName());
        System.out.println(dataSourceProperties);
        //执行SQL,输出查到的数据
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<?> resultList = jdbcTemplate.queryForList("select * from flyway_schema_history");
        System.out.println("===>>>>>>>>>>>" + JSON.toJSONString(resultList));
    }


}