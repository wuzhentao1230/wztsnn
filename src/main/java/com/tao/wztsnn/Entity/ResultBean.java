package com.tao.wztsnn.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ResultBean {
    private String desc;
    private String message;
    private int status;
    private Object data;
    public void makeSuccess(Object data){
        this.desc = "success";
        this.status = 200;
        this.data = data;
    }
    public void makeFail(String message){
        this.desc = "error";
        this.status = 400;
        this.message = message;
    }

    public void makeEmpty(){
        this.desc = "empty data";
        this.status = 300;
    }
}

