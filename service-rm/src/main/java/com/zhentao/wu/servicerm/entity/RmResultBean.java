package com.zhentao.wu.servicerm.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RmResultBean {
    private String desc;
    private String message;
    private int status;
    private Object data;
    public RmResultBean makeSuccess(Object data){
        this.desc = "success";
        this.status = 200;
        this.data = data;
        return this;
    }
    public RmResultBean makeFail(String message){
        this.desc = "error";
        this.status = 400;
        this.message = message;
        return this;
    }

    public void makeEmpty(){
        this.desc = "empty data";
        this.status = 300;
    }

    public void makeBusy(String message){
        this.desc = "server busy";
        this.status = 500;
        this.message = message;
    }

}

