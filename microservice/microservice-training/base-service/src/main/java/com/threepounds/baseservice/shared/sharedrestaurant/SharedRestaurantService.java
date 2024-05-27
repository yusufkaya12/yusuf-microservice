package com.threepounds.baseservice.shared.sharedrestaurant;

import com.threepounds.baseservice.common.ResponseModel;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class SharedRestaurantService {
    private final RestaurantFeignClient restaurantFeignClient;

    public ResponseModel<List<SharedRestaurant>> restaurant() {
        try {
            return restaurantFeignClient.getRestaurants().getBody();
        } catch (FeignException fe) {
            if (fe.status() != HttpStatus.NOT_FOUND.value()) {
                log.error("Unable to get user restaurants.", fe);
            }
            return null;
        }
    }

    public ResponseModel<SharedRestaurant> getRestaurantById(UUID id) {
        try {
            return restaurantFeignClient.getRestaurant(id).getBody();
        } catch (FeignException fe) {
            if (fe.status() != HttpStatus.NOT_FOUND.value()) {
                log.error("Unable to get user restaurant.", fe);
            }
            return null;
        }
    }

}
