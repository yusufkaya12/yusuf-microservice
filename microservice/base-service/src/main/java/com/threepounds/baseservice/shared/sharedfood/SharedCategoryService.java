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
public class SharedCategoryService {
    private final FoodFeignClient foodFeignClient;
    public ResponseModel<List<SharedCategory>> categories() {
        try {
            return foodFeignClient.getCategories().getBody();
        } catch (FeignException fe) {
            if (fe.status() != HttpStatus.NOT_FOUND.value()) {
                log.error("Unable to get user categories.", fe);
            }
            return null;
        }
    }
    public ResponseModel<SharedCategory>getCategoryById(UUID id) {

        try {

            return foodFeignClient.getCategory(id).getBody();


        } catch (FeignException fe) {
            if (fe.status() != HttpStatus.NOT_FOUND.value()) {
                log.error("Unable to get user category", fe);
            }

            return null;

        }

    }

}
