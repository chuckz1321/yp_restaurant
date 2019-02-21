package com.example.yp_restaurant.Dao;

import com.example.yp_restaurant.Entity.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ITUserDao {

    @Select("select * from user")
    List<TUser> getUserList();

}
