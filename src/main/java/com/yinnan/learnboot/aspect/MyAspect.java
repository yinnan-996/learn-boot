package com.yinnan.learnboot.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yinnan
 * Date: 2018/9/30
 * Time: 18:11
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@Aspect
@Component
@Slf4j
public class MyAspect {
    @Around(value = "execution(* com.yinnan.learnboot.controllers.FastJsonController..*(..))")
    public Object method(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("=====Aspect处理=======");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            log.info("参数为:" + arg);
        }

        long start = System.currentTimeMillis();

        Object object = pjp.proceed();

        log.info("Aspect 耗时:" + (System.currentTimeMillis() - start));

        return object;
    }
}
