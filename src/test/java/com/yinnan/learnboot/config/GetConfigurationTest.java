package com.yinnan.learnboot.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yinnan
 * Date: 2018/9/30
 * Time: 11:26
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@Slf4j
public class GetConfigurationTest {
    @Autowired
    @Qualifier("commonMap")
    protected Map<String, String> commonMap;

    @Test
    public void init() {
        log.info(String.valueOf(commonMap));
    }

    @Test
    public void commonMap() {
    }
}