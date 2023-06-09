package com.example.lifehealthassistant.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lifehealthassistant.dao.DiseaseDao;
import com.example.lifehealthassistant.dao.HealthDao;
import com.example.lifehealthassistant.domain.Disease;
import com.example.lifehealthassistant.domain.Health;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthServiceImpl extends ServiceImpl<HealthDao,Health> implements HealthService{
    @Autowired
    private HealthDao healthDao;

    @Override
    public Boolean saveHealth(Health health, String id) {
        return healthDao.insertHealth(health,id)>0;
    }

    @Override
    public List<Health> getHealthAll(String id) {
        List<Health> healthList=healthDao.selectAll(id);
        System.out.println(healthList);
        return healthList;
    }

    @Override
    public Boolean deleteHealth(Health health, String id) {
        return healthDao.deleteHealth(health,id)>0;
    }

    @Override
    public Boolean updateHealth(Health health, String id) {
        return healthDao.updateHealth(health,id)>0;
    }
}
