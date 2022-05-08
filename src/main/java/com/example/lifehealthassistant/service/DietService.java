package com.example.lifehealthassistant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.lifehealthassistant.controller.utils.R;
import com.example.lifehealthassistant.domain.Diet;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface DietService extends IService<Diet> {
    R saveDietPic(List<MultipartFile> files);



}
