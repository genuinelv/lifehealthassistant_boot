package com.example.lifehealthassistant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.lifehealthassistant.controller.utils.R;
import com.example.lifehealthassistant.domain.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserInfoService extends IService<User> {
    R saveUserPic(MultipartFile file);
    Boolean deleteById(int id);
}
