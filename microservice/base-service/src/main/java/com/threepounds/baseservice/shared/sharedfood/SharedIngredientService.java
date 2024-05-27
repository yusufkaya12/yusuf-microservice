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
public class SharedIngredientService {
    private final FoodFeignClient foodFeignClient;


    public ResponseModel<List<SharedIngredient>> ingredients() {
        try {
            return foodFeignClient.getIngredients().getBody();
        } catch (FeignException fe) {
            if (fe.status() != HttpStatus.NOT_FOUND.value()) {
                log.error("Unable to get user ingredient.", fe);
            }
            return null;
        }
    }
    public ResponseModel<SharedIngredient>getIngredientById(UUID id) {

        try {

            return foodFeignClient.getIngredient(id).getBody();


        } catch (FeignException fe) {
            if (fe.status() != HttpStatus.NOT_FOUND.value()) {
                log.error("Unable to get user ingredient", fe);
            }

            return null;

        }

    }
}
