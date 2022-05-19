package com.example.lifehealthassistant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.lifehealthassistant.domain.Disease;
import com.example.lifehealthassistant.domain.Health;

import java.util.List;

public interface HealthService extends IService<Health> {
    Boolean saveHealth(Health health, String id);
    List<Health> getHealthAll(String id);
    Boolean deleteHealth(Health health,String id);
    Boolean updateHealth(Health health,String id);
}
