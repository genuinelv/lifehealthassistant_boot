package com.example.lifehealthassistant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.lifehealthassistant.controller.utils.R;
import com.example.lifehealthassistant.domain.User;
import com.example.lifehealthassistant.domain.Useremail;

public interface UserEmailService extends IService<Useremail> {
    boolean sendemail(String email);

    //绑定邮箱
    R sendbindcode(String id, String email);//传入email,实现里传库4样,id注册时就传入了
    R checkbingcode(String id,String code,int i);//从库取出两样，传库1样,i=1，验证绑定邮箱时的码
    //从库取出两样，不传库,i=2,验证修改密码时的码
    //        忘记密码
    R getPs(String id);//直接给
    //    修改密码
    R sendbindcode(String id);//传库两样
}
