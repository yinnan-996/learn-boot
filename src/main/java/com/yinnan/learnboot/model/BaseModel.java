package com.yinnan.learnboot.model;

import java.util.List;

public class BaseModel {
    private List<?> list;

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "list=" + list +
                '}';
    }
}
