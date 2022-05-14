package com.example.lifehealthassistant.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lifehealthassistant.dao.UserInfoDao;
import com.example.lifehealthassistant.domain.User;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, User> implements UserInfoService{

    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public boolean save(User user) {
        userInfoDao.save_create_diet(user);
        userInfoDao.save_create_disease(user);
        return (userInfoDao.insert(user)>0);
    }
}
