package com.example.lifehealthassistant.controller;


import com.example.lifehealthassistant.controller.utils.R;
import com.example.lifehealthassistant.domain.User;
import com.example.lifehealthassistant.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,userInfoService.getById(id));
    }
    @GetMapping
    public R getAll(){
        return new R(true,userInfoService.list());
    }

    @PostMapping
    public R save(@RequestBody User user){
        return new R(userInfoService.save(user));
    }

    @PutMapping
    public R update(@RequestBody User user) {
        return new R(userInfoService.updateById(user));
    }
}
