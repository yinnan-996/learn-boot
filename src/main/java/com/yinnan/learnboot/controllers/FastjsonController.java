package com.yinnan.learnboot.controllers;

import com.yinnan.learnboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yinnan
 * Date: 2018/9/30
 * Time: 17:40
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@Controller
@RequestMapping("fastjson")
public class FastjsonController {
    @RequestMapping("/test")
    @ResponseBody
    public User test() {
        User user = new User();
        user.setId(1);
        user.setUsername("yinnan");
        user.setPassword("menacy");
        user.setBirthday(new Date());
        return user;
    }
}
