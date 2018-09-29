package com.yinnan.learnboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yinnan
 * Date: 2018/9/29
 * Time: 11:44
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@RestController
public class LoginController {
    @GetMapping("/helloworld")
    public String helloworld() {
        return "helloworld";
    }

    @GetMapping("/helloworld2")
    public String helloworld2() {
        return "helloworld2";
    }
}
