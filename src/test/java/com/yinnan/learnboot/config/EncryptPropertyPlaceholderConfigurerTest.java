package com.yinnan.learnboot.config;

import com.yinnan.learnboot.LearnBootApplication;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yinnan
 * Date: 2018/9/30
 * Time: 14:36
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
//@WebAppConfiguration
public class EncryptPropertyPlaceholderConfigurerTest {

    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    public void getPass() {
        String name = stringEncryptor.encrypt("root");
        String password = stringEncryptor.encrypt("menacy");
        log.info("name={}",name);
        log.info("password={}",password);
    }


    @Value("${ds.userName}")
    private String userName;

    @Autowired
    private Environment environment;


    @Test
    public void getValue(){
        log.info(userName);
    }
}

