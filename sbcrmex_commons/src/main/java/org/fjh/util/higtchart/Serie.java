package org.fjh.util.higtchart;

import java.util.ArrayList;
import java.util.List;

public class Serie {
    private String name;// 数据名称
    private List<Object> data = new ArrayList<>();// 数据
    private String stack;// 数据所在组

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }
}
