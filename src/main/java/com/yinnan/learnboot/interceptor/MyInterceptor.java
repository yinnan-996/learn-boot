package com.yinnan.learnboot.interceptor;

import com.alibaba.fastjson.JSON;
import com.yinnan.learnboot.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yinnan
 * Date: 2018/9/30
 * Time: 18:04
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@Slf4j
@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("========preHandle=========");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();


        request.setAttribute("startTime", System.currentTimeMillis());
        //如果验证token失败
        if (method.getAnnotation(TestAnnotation.class) == null) {
            log.info("TestAnnotation = {}", "null");
            return true;
        }
        TestAnnotation testAnnotation = method.getAnnotation(TestAnnotation.class);
        log.info("TestAnnotation = {}", testAnnotation.param());
        TestAnnotation2 testAnnotation2 = method.getAnnotation(TestAnnotation2.class);
        log.info("TestAnnotation2 = {}", testAnnotation2.param());
        TestAnnotation3 testAnnotation3 = method.getAnnotation(TestAnnotation3.class);
        log.info("TestAnnotation3 = {}", testAnnotation3.param());
        TestAnnotation4 testAnnotation4 = method.getAnnotation(TestAnnotation4.class);
        log.info("TestAnnotation4 = {}", testAnnotation4.param());
        TestAnnotation5 testAnnotation5 = method.getAnnotation(TestAnnotation5.class);
        log.info("TestAnnotation5 = {}", testAnnotation5.param());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {

        log.info("========postHandle=========");
        Long start = (Long) request.getAttribute("startTime");
        log.info("耗时:"+(System.currentTimeMillis() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
            throws Exception {

        log.info("========afterCompletion=========");
        Long start = (Long) request.getAttribute("startTime");
        log.info("耗时:"+(System.currentTimeMillis() - start));

        log.info(String.valueOf(exception));
    }

}
