package com.example.lifehealthassistant.dao;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lifehealthassistant.domain.Diet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DietDao extends BaseMapper<Diet> {


    @Select("SELECT * FROM #{id}_diet")
    List<Diet> selectAll(int id);


    @Select("SELECT * FROM #{id}_diet WHERE TO_DAYS(datetime) = TO_DAYS(#{date}) AND dietname=#{adietname}")
    List<Diet> selectPrimary(String date, int id, String adietname);

    @Insert("INSERT INTO #{id}_diet(datetime, food, dietname,picture1,picture2,picture3) " +
            "VALUES(#{diet.datetime}, #{diet.food}, #{diet.dietname},#{diet.picture1}," +
            "#{diet.picture2},#{diet.picture3})")
    int insertDiet(Diet diet,int id);

}
