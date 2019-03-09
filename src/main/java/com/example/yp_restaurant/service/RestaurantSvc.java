package com.example.yp_restaurant.service;

import com.example.yp_restaurant.Entity.Restaurant;
import java.util.List;

public interface RestaurantSvc {
    public abstract List<Restaurant> getMuseumListByState(String state);
    public abstract List<Restaurant> getMuseumListByAddress(String address);
    public abstract List<Restaurant> getMuseumListByCity(String city);
    public abstract List<Restaurant> getMuseumListByName(String name);
    public abstract List<Restaurant> getMuseumListByType(String type);
}
