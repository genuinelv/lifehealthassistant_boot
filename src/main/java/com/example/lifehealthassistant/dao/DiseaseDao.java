package com.example.lifehealthassistant.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lifehealthassistant.domain.Diet;
import com.example.lifehealthassistant.domain.Disease;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DiseaseDao extends BaseMapper<Disease> {

    @Select("SELECT * FROM #{id}_disease")
    List<Disease> selectAll(int id);


    @Select("SELECT * FROM #{id}_disease WHERE diseasename like '%${value}%'")
    List<Disease> selectByDiseasename(int id, String value);

    @Insert("INSERT INTO #{id}_disease(datestart, dateend, diseasename, symptom,sympic,medicine,medpic) " +
            "VALUES(#{disease.datestart}, #{disease.dateend}, #{disease.diseasename},#{disease.symptom}," +
            "#{disease.sympic},#{disease.medicine},#{disease.medpic})")
    int insertDisease(Disease disease,int id);

    @Delete("DELETE FROM #{id}_disease WHERE datestart=#{disease.datestart} " +
            "and dateend=#{disease.dateend} and diseasename=#{disease.diseasename}")
    int deleteDisease(Disease disease,int id);
}
