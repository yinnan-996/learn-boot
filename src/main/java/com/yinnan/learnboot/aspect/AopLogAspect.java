package com.yinnan.learnboot.aspect;

import com.yinnan.learnboot.annotation.AopLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Description:  -----require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yinnan
 * Date: 2019-07-12
 * Time: 16:42
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@Aspect
@Component
@Slf4j
public class AopLogAspect {

    @Pointcut("@annotation(aopLog) ")
    public void aopLogAspect(AopLog aopLog ){

    }

    @Before("aopLogAspect(aopLog)")
    public void doBefore(JoinPoint joinPoint, AopLog aopLog) throws Throwable {
        log.info("AopLogAspect doBefore");
    }

//    @AfterReturning(returning = "result", pointcut = "aopLogAspect(aopLog)")
//    public void doAfterReturning(Object result,  AopLog aopLog) {
//
//    }
}
