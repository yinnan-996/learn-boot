//package com.yinnan.learnboot.config;
//
//import com.yinnan.learnboot.utils.DESUtils;
//import lombok.Data;
//import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
///**
// * Created by IntelliJ IDEA.
// * Description:  ---——require需求|ask问题|jira
// * Design :  ----the  design about train of thought 设计思路
// * User: yinnan
// * Date: 2018/9/30
// * Time: 14:14
// * Email:yinnan@huli.com
// *
// * @author yinnan
// * @since 1.0-SNAPSHOT
// */
//@Configuration
//@ComponentScan
//public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
//    private String[] encryptPropNames = {"username", "password"};
//    @Override
//    protected String convertProperty(String propertyName, String propertyValue) {
//        //如果在加密属性名单中发现该属性
//        if (isEncryptProp(propertyName)) {
//            String decryptValue = DESUtils.getDecryptString(propertyValue);
//            System.out.println(decryptValue);
//            return decryptValue;
//        }else {
//            return propertyValue;
//        }
//    }
//    private boolean isEncryptProp(String propertyName) {
//        for (String encryptName : encryptPropNames) {
//            if (encryptName.equals(propertyName)) {
//                return true;
//            }
//        }
//        return false;
//    }
//}
//
