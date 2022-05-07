package com.example.lifehealthassistant.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lifehealthassistant.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserInfoDao extends BaseMapper<User> {

}
