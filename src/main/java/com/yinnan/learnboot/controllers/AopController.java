package com.yinnan.learnboot.controllers;

import com.yinnan.learnboot.model.User;
import com.yinnan.learnboot.service.AopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * Description:  -----require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yinnan
 * Date: 2019-07-12
 * Time: 16:44
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@Slf4j
@Controller
@RequestMapping("aop")
public class AopController {

    @Autowired
    private AopService aopService;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        aopService.methodOne();
        log.info("methodOne end");
        aopService.methodTwo();
        log.info("methodTwo end");
        aopService.methodThird();
        log.info("methodThird end");
        return "调用成功";
    }
}
