package com.yinnan.learnboot.beanDefinition;

import com.yinnan.learnboot.mybean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * Created by IntelliJ IDEA.
 * Description:  -----require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yinnan
 * Date: 2018/12/13
 * Time: 16:47
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@Slf4j
@Component
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<User> getBeanClass(Element element){
        log.info("UserBeanDefinitionParser getBeanClass begin");
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        log.info("UserBeanDefinitionParser doParse begin");
        String userName = element.getAttribute("userName");
        String email = element.getAttribute("email");
        String password = element.getAttribute("password");
        if(StringUtils.hasText(userName)){
            builder.addPropertyValue("userName",userName);
        }
        if(StringUtils.hasText(email)){
            builder.addPropertyValue("email",email);
        }
        if(StringUtils.hasText(password)){
            builder.addPropertyValue("password",password);
        }
    }
}
