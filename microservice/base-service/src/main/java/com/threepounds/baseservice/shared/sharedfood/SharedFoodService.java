package com.threepounds.baseservice.shared.sharedfood;

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
public class SharedFoodService {
    private final FoodFeignClient foodFeignClient;


    public ResponseModel<List<SharedFood>> foods() {
        try {
            return foodFeignClient.getFoods().getBody();
        } catch (FeignException fe) {
            if (fe.status() != HttpStatus.NOT_FOUND.value()) {
                log.error("Unable to get user foods.", fe);
            }
            return null;
        }
    }

    public ResponseModel<SharedFood>getFoodById(UUID id) {
        try {
            return foodFeignClient.getFood(id).getBody();
        } catch (FeignException fe) {
            if (fe.status() != HttpStatus.NOT_FOUND.value()) {
                log.error("Unable to get user food", fe);
            }
            return null;
        }
    }
}
