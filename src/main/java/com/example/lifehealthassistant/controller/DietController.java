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
        return dietService.saveDietPic(files);
    }

    @PostMapping("/save_diet")
    @ResponseBody
    public R save(@RequestBody Diet diet){
        System.out.println(diet);
        return new R(dietService.save(diet));
                //saveDiet(diet);
    }

}
