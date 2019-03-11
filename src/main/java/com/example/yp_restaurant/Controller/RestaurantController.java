package com.example.yp_restaurant.Controller;


import com.example.yp_restaurant.Entity.RequestQuery;
import com.example.yp_restaurant.Entity.ResponseMessage;
import com.example.yp_restaurant.Entity.Restaurant;
import com.example.yp_restaurant.service.impl.RestaurantSvcImpl;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/restaurant", method = RequestMethod.POST)
public class RestaurantController {
    @Autowired
    RestaurantSvcImpl svc;

    /*public abstract List<Restaurant> getRestaurantListByState(String state);
    public abstract List<Restaurant> getRestaurantListByAddress(String address);
    public abstract List<Restaurant> getRestaurantListByCity(String city);
    public abstract List<Restaurant> getRestaurantListByName(String name);
    public abstract List<Restaurant> getRestaurantListByType(String type);*/

    @RequestMapping(value="/test",method=RequestMethod.GET)
    @ResponseBody
    public ResponseMessage<List<Restaurant>> test(@RequestParam("country") String country){
        svc.getRestaurantListByState("PIONEER HISTORICAL SOCIETY INC");
        svc.getRestaurantListByAddress("FARMINGTON");
        svc.getRestaurantListByCity("PO BOX 132");
        svc.getRestaurantListByName("PO BOX 132");
        ResponseMessage message = new ResponseMessage();
        message.setResponseBody(svc.getRestaurantListByType("IA"));
        message.setHttpCode("200");
        return message;
    }

    @ResponseBody
    public List<Restaurant> processQuery(@RequestBody RequestQuery inputQuery){
        String query = inputQuery.getQuery();
        List<Restaurant> restaurant = new ArrayList<Restaurant>();
        String[] subqueries = query.split("&");
        for(String subquery: subqueries){
            String[] queryParts = subquery.split("=");
            switch(queryParts[0]){
                case "restaurantState":
                    if( !queryParts[1].equals("") ) {
                        restaurant = svc.getRestaurantListByState(queryParts[1]);
                    }
                    break;
                case "restaurantAddress":
                    if( !queryParts[1].equals("") ) {
                        restaurant = svc.getRestaurantListByAddress(queryParts[1]);
                    }
                    break;
                case "restaurantName":
                    if (!queryParts[1].equals("")){
                        restaurant = svc.getRestaurantListByName(queryParts[1]);
                    }
                    break;
                case "restaurantType":
                    if (!queryParts[1].equals("")){
                        restaurant = svc.getRestaurantListByType(queryParts[1]);
                    }
                    break;
                case "restaurantCity":
                    if (!queryParts[1].equals("")){
                        restaurant = svc.getRestaurantListByCity(queryParts[1]);
                    }
                    break;
            }
        }

        ResponseMessage<List<Restaurant>> message = new ResponseMessage<List<Restaurant>>();
        message.setResponseBody(restaurant);
        return restaurant;
    }
}
