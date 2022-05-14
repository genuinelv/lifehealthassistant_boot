package com.example.lifehealthassistant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.lifehealthassistant.controller.utils.R;
import com.example.lifehealthassistant.domain.Diet;
import com.example.lifehealthassistant.domain.Disease;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DiseaseService extends IService<Disease> {

    R saveDiseasePic(List<MultipartFile> files);
    Boolean saveDisease(Disease disease, int id);
    List<Disease> getDiseaseAll(int id);
    List<Disease> getDiseaseByName(String name,int id);
    Boolean deleteDisease(Disease disease,int id);

}
