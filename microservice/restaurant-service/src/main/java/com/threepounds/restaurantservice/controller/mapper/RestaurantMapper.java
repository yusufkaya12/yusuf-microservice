package com.threepounds.restaurantservice.controller.mapper;

import com.threepounds.restaurantservice.controller.dto.RestaurantDto;
import com.threepounds.restaurantservice.controller.resource.RestaurantResource;
import com.threepounds.restaurantservice.data.entity.Restaurant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    Restaurant dtoToEntity(RestaurantDto restaurantDto);

    List<RestaurantResource> resourceToList(List<Restaurant> restaurantResources);

    RestaurantResource entityToResource(Restaurant restaurant);
}
