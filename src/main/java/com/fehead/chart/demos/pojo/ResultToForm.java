package com.fehead.chart.demos.pojo;

import java.util.List;

public class ResultToForm {
    private List message;
    private  Integer length;
    private Integer code ;

    public List getMessage() {
        return message;
    }

    public void setMessage(List message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
