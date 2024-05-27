package com.threepounds.restaurantservice.service;

import com.threepounds.restaurantservice.data.entity.Restaurant;
import com.threepounds.restaurantservice.data.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public void delete(UUID id) {
        restaurantRepository.deleteById(id);
    }

    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> list() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getById(UUID id) {
        return restaurantRepository.findById(id);
    }


}
