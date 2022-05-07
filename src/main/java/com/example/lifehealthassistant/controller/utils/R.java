package com.example.lifehealthassistant.controller.utils;

import com.example.lifehealthassistant.domain.User;
import lombok.Data;

@Data
public class R<T> {
    private Boolean flag;
    private T data;

    public R(){}

    public R(Boolean flag){
        this.flag=flag;
        this.data=null;
    }

    public R(Boolean flag, T data){
        this.flag=flag;
        this.data=data;
    }
}