package com.yinnan.learnboot.model;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yinnan
 * Date: 2018/9/30
 * Time: 18:34
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@Data
public class FileInfo {

    private String path;

    public FileInfo(String path) {
        this.path = path;
    }
}
