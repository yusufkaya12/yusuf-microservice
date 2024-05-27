package com.threepounds.restaurantservice.controller;

import com.threepounds.baseservice.common.exceptions.NotFoundException;
import com.threepounds.baseservice.shared.sharedcity.SharedCityService;
import com.threepounds.baseservice.shared.sharedcity.SharedCountyService;
import com.threepounds.baseservice.shared.sharedcity.SharedStreetService;
import com.threepounds.baseservice.shared.sharedfood.SharedCategoryService;
import com.threepounds.restaurantservice.controller.dto.RestaurantDto;
import com.threepounds.restaurantservice.controller.mapper.RestaurantMapper;
import com.threepounds.restaurantservice.controller.resource.RestaurantResource;
import com.threepounds.restaurantservice.controller.response.ResponseModel;
import com.threepounds.restaurantservice.data.entity.Restaurant;
import com.threepounds.restaurantservice.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantMapper restaurantMapper;
    private final RestaurantService restaurantService;

    private final SharedCityService sharedCityService;
    private final SharedStreetService sharedStreetService;
    private final SharedCountyService sharedCountyService;
    private final SharedCategoryService sharedCategory;


    public RestaurantController(RestaurantMapper restaurantMapper, RestaurantService restaurantService,
                                SharedCityService sharedCityService, SharedStreetService sharedStreetService, SharedCountyService sharedCountyService, SharedCategoryService sharedCategory) {
        this.restaurantMapper = restaurantMapper;
        this.restaurantService = restaurantService;
        this.sharedCityService = sharedCityService;
        this.sharedStreetService = sharedStreetService;
        this.sharedCountyService = sharedCountyService;

        this.sharedCategory = sharedCategory;
    }

    @PostMapping("/")
    public ResponseModel<RestaurantResource> create(@RequestBody RestaurantDto restaurantDto) {
        Restaurant saveRestaurant = restaurantMapper.dtoToEntity(restaurantDto);
        saveRestaurant.setCityId(sharedCityService.getCityById(restaurantDto.getCityId()).getBody().getId());
        saveRestaurant.setCountyId(sharedCountyService.county(restaurantDto.getCountyId()).getBody().getId());
        saveRestaurant.setStreetId(sharedStreetService.street(restaurantDto.getStreetId()).getBody().getId());
        restaurantService.save(saveRestaurant);
        RestaurantResource restaurantResource = restaurantMapper.entityToResource(saveRestaurant);
        return new ResponseModel<>(HttpStatus.OK.value(), restaurantResource, null);
    }

    @DeleteMapping("/{id}")
    public ResponseModel<String> remove(@PathVariable UUID id) {
        restaurantService.delete(id);
        return new ResponseModel<>(HttpStatus.OK.value(), "Restaurant removed", null);
    }

    @GetMapping("/")
    public ResponseModel<List<RestaurantResource>> getAll() {
        List<Restaurant> restaurants = restaurantService.list();
        List<RestaurantResource> restaurantResources = restaurantMapper.resourceToList(restaurants);
        return new ResponseModel<>(HttpStatus.OK.value(), restaurantResources, null);
    }

    @GetMapping("/{id}")
    public ResponseModel<RestaurantResource> getById(@PathVariable UUID id) {
        Restaurant restaurant = restaurantService.getById(id).orElseThrow(() ->
                new NotFoundException("Restaurant not found"));
        RestaurantResource restaurantResource = restaurantMapper.entityToResource(restaurant);
        return new ResponseModel<>(HttpStatus.OK.value(), restaurantResource, null);
    }
}
