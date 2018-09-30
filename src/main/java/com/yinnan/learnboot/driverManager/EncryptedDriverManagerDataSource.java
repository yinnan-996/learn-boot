package com.yinnan.learnboot.driverManager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yinnan
 * Date: 2018/9/30
 * Time: 11:52
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@Slf4j
@Configuration
@ComponentScan
public class EncryptedDriverManagerDataSource extends DriverManagerDataSource {

    public EncryptedDriverManagerDataSource() {
    }

    public EncryptedDriverManagerDataSource(String url, String username, String password) {
        setUrl(url);
        setUsername(username);
        String decryptedPass = someDecryptMethod(password);
        setPassword(decryptedPass);
    }

    private String someDecryptMethod(String password) {
        String string =  password.replaceAll("p","");
        log.info(string);
        return "aaaaaa";
    }

}
