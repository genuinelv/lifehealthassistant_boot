package com.example.lifehealthassistant.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lifehealthassistant.controller.utils.R;
import com.example.lifehealthassistant.dao.DietDao;
import com.example.lifehealthassistant.dao.DiseaseDao;
import com.example.lifehealthassistant.domain.Diet;
import com.example.lifehealthassistant.domain.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class DiseaseServiceImpl extends ServiceImpl<DiseaseDao, Disease> implements DiseaseService{

    @Autowired
    private DiseaseDao diseaseDao;

    @Override
    public R saveDiseasePic(List<MultipartFile> files) {
        int filescount=files.size();

        Disease disease=new Disease();
        for(int i=0;i<filescount;i++) {

            if (files.get(i).isEmpty()) {//System.out.println("到saveDietPic循环判断空了");
                return new R(false, "文件名为空");
            }
            String originFilename = files.get(i).getOriginalFilename();
            System.out.println(originFilename);
            String fileName = System.currentTimeMillis() + "." + originFilename.substring(originFilename.lastIndexOf(".") + 1);
            String filePath = "D:\\pic_disease\\";
            File dest = new File(filePath + fileName);

            if (i == 0)
                disease.setSympic(filePath + fileName);
            else
                disease.setMedpic(filePath + fileName);

            if (!dest.getParentFile().exists())
                dest.getParentFile().mkdirs();
            try {
                files.get(i).transferTo(dest);
            } catch (Exception e) {
                e.printStackTrace();
                return new R(false, "上传失败，服务器错误");
            }
        }
        return new R(true,disease);
    }

    @Override
    public Boolean saveDisease(Disease disease, int id) {
        return diseaseDao.insertDisease(disease,id)>0;
    }

    @Override
    public List<Disease> getDiseaseAll(int id) {
        return diseaseDao.selectAll(id);
    }

    @Override
    public List<Disease> getDiseaseByName(String name, int id) {
        return diseaseDao.selectByDiseasename(id,name);
    }

    @Override
    public Boolean deleteDisease(Disease disease, int id) {
        File file=new File(disease.getSympic());
        File file1=new File(disease.getMedpic());
        if(!(file.delete()&&file1.delete()))
            return false;
        System.out.println(disease);
        return diseaseDao.deleteDisease(disease,id)>0;
    }
}
