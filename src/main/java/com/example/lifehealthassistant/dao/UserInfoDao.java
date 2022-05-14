package com.example.lifehealthassistant.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lifehealthassistant.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserInfoDao extends BaseMapper<User> {

    @Update("create table #{id}_diet" +
            "(" +
            "datetime datetime not null," +
            "food VARCHAR(255)," +
            "dietname VARCHAR(255)," +
            "picture1 VARCHAR(255)," +
            "picture2 VARCHAR(255)," +
            "picture3 VARCHAR(255)," +
            "PRIMARY KEY(datetime,dietname)" +
            ");")
    public boolean save_create_diet(User user);

    @Update("create table #{id}_disease" +
            "(" +
            "datestart datetime not null," +
            "dateend datetime not null," +
            "diseasename VARCHAR(255) not null," +
            "symptom VARCHAR(255)," +
            "sympic VARCHAR(255)," +
            "medicine VARCHAR(255)," +
            "medpic VARCHAR(255)," +
            "PRIMARY KEY(datestart,dateend,diseasename)" +
            ");")
    public boolean save_create_disease(User user);


}
