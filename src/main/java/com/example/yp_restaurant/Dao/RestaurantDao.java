package com.example.yp_restaurant.Dao;

import com.example.yp_restaurant.Entity.Restaurant;
import java.util.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

public interface RestaurantDao {
    public abstract List<Restaurant> getRestaurantListByState(String state);
    public abstract List<Restaurant> getRestaurantListByAddress(String address);
    public abstract List<Restaurant> getRestaurantListByCity(String city);
    public abstract List<Restaurant> getRestaurantListByName(String name);
    public abstract List<Restaurant> getRestaurantListByType(String type);
}
