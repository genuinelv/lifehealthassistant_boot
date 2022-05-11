package com.example.lifehealthassistant.controller;


import com.example.lifehealthassistant.controller.utils.R;
import com.example.lifehealthassistant.dao.DietDao;
import com.example.lifehealthassistant.domain.Diet;
import com.example.lifehealthassistant.service.DietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/diet")
public class DietController {

    @Autowired
    private DietService dietService;

    @PostMapping("/save_diet_pic")
    public R save(@RequestParam("file") List<MultipartFile> files){
        System.out.println(files);
        System.out.println(files.size());
        R re=dietService.saveDietPic(files);
        System.out.println(re);
        return re;
    }

    @PostMapping("/save_diet")
    @ResponseBody
    public R save(@RequestBody Diet diet,@RequestParam("id") Integer userid){
        System.out.println(diet);
        System.out.println(userid);
        if(dietService.checkPrimary(diet,userid)){
            System.out.println("这一天的这一顿饭已经登记了");
            return new R(false,"这一天的这一顿饭已经登记了");
        }
        Boolean bl=dietService.saveDiet(diet,userid);
        System.out.println(bl);
        return new R(bl);

    }

}
