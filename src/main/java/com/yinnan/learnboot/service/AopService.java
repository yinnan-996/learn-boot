package com.yinnan.learnboot.service;

import com.yinnan.learnboot.annotation.AopLog;
import com.yinnan.learnboot.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Description:  -----require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yinnan
 * Date: 2019-07-12
 * Time: 16:30
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@Slf4j
@Service
public class AopService {

    private AopService aopService = null;

    private AopService getAop(){
        if (aopService != null){
            return aopService;
        }else {
            synchronized (AopService.class){
                aopService = SpringUtil.getBean(AopService.class);
            }
        }
        return aopService;
    }

    public void methodOne(){
        log.info("methodOne begin");
        getAop().methodAop();
    }

    public void methodTwo(){
        log.info("methodTwo begin");
        ((AopService) AopContext.currentProxy()).methodAop();
    }

    public void methodThird(){
        log.info("methodThird begin");
        methodAop();
    }

    @AopLog
    public void methodAop(){
        log.info("methodAop begin");
    }
}
