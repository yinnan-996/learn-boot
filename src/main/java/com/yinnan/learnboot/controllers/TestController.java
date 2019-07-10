package com.yinnan.learnboot.controllers;

import com.yinnan.learnboot.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Description:  -----require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yinnan
 * Date: 2019-07-09
 * Time: 11:49
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@Slf4j
@RestController
@RequestMapping("test")
public class TestController {

    @TestAnnotation(param = "#param")
    @TestAnnotation2(param = "#{param)")
    @TestAnnotation3(param = "$param")
    @TestAnnotation4(param = "${param}")
    @TestAnnotation5(param = "{param}")
    @RequestMapping("/helloworld")
    public String helloworld(@RequestParam("param") String param) {
        log.info("param = {}", param);
        return "helloworld";
    }
}
