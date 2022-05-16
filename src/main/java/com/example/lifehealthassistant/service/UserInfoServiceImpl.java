package com.example.lifehealthassistant.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lifehealthassistant.controller.utils.R;
import com.example.lifehealthassistant.dao.UserInfoDao;
import com.example.lifehealthassistant.domain.User;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

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

    @Override
    public R saveUserPic(MultipartFile file) {
        if(file.isEmpty()){System.out.println("到saveDietPic循环判断空了");
            return new R(false,"文件名为空");
        }
        String originFilename =file.getOriginalFilename();
        System.out.println(originFilename);
        String fileName=System.currentTimeMillis()+"."+originFilename.substring(originFilename.lastIndexOf(".")+1);
        String filePath = "D:\\pic_user\\";
        File dest = new File(filePath+fileName);
        User user=new User();
        user.setPhoto(filePath+fileName);

        if(!dest.getParentFile().exists())
            dest.getParentFile().mkdirs();
        try {
            file.transferTo(dest);
        }catch (Exception e){
            e.printStackTrace();
            return new R(false,"上传失败，服务器错误");

        }
        return new R(true,user);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Boolean deleteById(int id) {
        userInfoDao.delete_diet(id);
        userInfoDao.delete_disease(id);
        User user=userInfoDao.selectById(id);
        String filename=user.getPhoto();
        File file=new File(filename);
        file.delete();
        return userInfoDao.deleteById(id)>0;
    }
}
