package com.example.lifehealthassistant.controller;


import com.example.lifehealthassistant.controller.utils.R;
import com.example.lifehealthassistant.domain.User;
import com.example.lifehealthassistant.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,userInfoService.getById(id));
    }

    @PostMapping
    public R save(@RequestBody User user){
        return new R(userInfoService.save(user));
    }

    @PutMapping
    public R updatepic(@RequestParam("file") MultipartFile file) {
        return userInfoService.saveUserPic(file);
    }
    @PutMapping("/{id}")
    public R update(@RequestBody User user,@PathVariable Integer id) {
        return new R(userInfoService.updateById(user));
    }

    @DeleteMapping("/{id}")
    public R remove(@PathVariable Integer id){
        return new R(userInfoService.deleteById(id));
    }
}
