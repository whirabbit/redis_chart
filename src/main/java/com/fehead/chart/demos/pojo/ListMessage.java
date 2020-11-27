package com.fehead.chart.demos.pojo;

public class ListMessage {
    private String name;
    //项目下接口调用总次数
    private Integer total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ListMessage{" +
                "name='" + name + '\'' +
                ", total=" + total +
                '}';
    }
}
