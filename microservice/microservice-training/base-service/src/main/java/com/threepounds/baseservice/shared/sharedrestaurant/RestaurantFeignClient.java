package com.threepounds.baseservice.shared.sharedrestaurant;

import com.threepounds.baseservice.common.ResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@FeignClient("restaurant-service")
public interface RestaurantFeignClient {
    @RequestMapping(value = SharedRestaurantEndPoints.RESTAURANTS, method = RequestMethod.GET)
    ResponseEntity<ResponseModel<List<SharedRestaurant>>> getRestaurants();

    @RequestMapping(value = SharedRestaurantEndPoints.RESTAURANT_ID, method = RequestMethod.GET)
    ResponseEntity<ResponseModel<SharedRestaurant>> getRestaurant(@PathVariable UUID id);
}
