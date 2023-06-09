package com.example.lifehealthassistant.controller.utils;

import com.example.lifehealthassistant.domain.User;
import lombok.Data;

@Data
public class R<T> {
    private Boolean flag;
    private String message;
    private T data;

    public R(){}

    public R(Boolean flag){
        this.flag=flag;
        this.message=null;
        this.data=null;
    }

    public R(Boolean flag, String message,T data){
        this.flag=flag;
        this.message=message;
        this.data=data;
    }
}