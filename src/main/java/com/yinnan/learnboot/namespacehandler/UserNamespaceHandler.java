package com.yinnan.learnboot.namespacehandler;

import com.yinnan.learnboot.beanDefinition.UserBeanDefinitionParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Description:  -----require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yinnan
 * Date: 2018/12/13
 * Time: 16:57
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@Slf4j
@Component
public class UserNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        log.info("UserNamespaceHandler init begin");
        registerBeanDefinitionParser("user", new  UserBeanDefinitionParser() );
    }
}
