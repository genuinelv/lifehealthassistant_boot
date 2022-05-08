package com.example.lifehealthassistant.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lifehealthassistant.controller.utils.R;
import com.example.lifehealthassistant.dao.DietDao;
import com.example.lifehealthassistant.domain.Diet;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class DietServiceImpl extends ServiceImpl<DietDao, Diet> implements DietService{


    private DietDao dietDao;

//    @Override
//    public R saveDiet(List<MultipartFile> files, Diet diet) {
//        int filescount=files.size();
//        for(int i=0;i<filescount;i++){
//            if(files.get(i).isEmpty()){
//                return new R(false,"文件名为空");
//            }
//            String originFilename =files.get(i).getOriginalFilename();
//            String fileName=System.currentTimeMillis()+"."+originFilename.substring(originFilename.lastIndexOf(".")+1);
//            String filePath = "D:\\pic\\";
//            File dest = new File(filePath+fileName);
//
//            if(i==0)
//                diet.setPicture1(filePath+fileName);
//            else if(i==1)
//                diet.setPicture2(filePath+fileName);
//            else
//                diet.setPicture3(filePath+fileName);
//
//            if(!dest.getParentFile().exists())
//                dest.getParentFile().mkdirs();
//            try {
//                files.get(i).transferTo(dest);
//            }catch (Exception e){
//                e.printStackTrace();
//                return new R(false,"上传失败，服务器错误");
//
//            }
//
//        }
//
//        return new R(dietDao.insert(diet)>0,"上传成功");
//    }

    @Override
    public R saveDietPic(List<MultipartFile> files) {
        int filescount=files.size();
        Diet diet=new Diet();
        for(int i=0;i<filescount;i++){
            if(files.get(i).isEmpty()){
                return new R(false,"文件名为空");
            }
            String originFilename =files.get(i).getOriginalFilename();
            String fileName=System.currentTimeMillis()+"."+originFilename.substring(originFilename.lastIndexOf(".")+1);
            String filePath = "D:\\pic\\";
            File dest = new File(filePath+fileName);

            if(i==0)
                diet.setPicture1(filePath+fileName);
            else if(i==1)
                diet.setPicture2(filePath+fileName);
            else
                diet.setPicture3(filePath+fileName);

            if(!dest.getParentFile().exists())
                dest.getParentFile().mkdirs();
            try {
                files.get(i).transferTo(dest);
            }catch (Exception e){
                e.printStackTrace();
                return new R(false,"上传失败，服务器错误");

            }

        }
        return new R(true,diet);
    }


}
