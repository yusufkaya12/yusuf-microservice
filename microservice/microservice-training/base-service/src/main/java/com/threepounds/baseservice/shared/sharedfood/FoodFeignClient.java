package com.threepounds.baseservice.shared.sharedfood;

import com.threepounds.baseservice.common.ResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@FeignClient("food-service")
public interface FoodFeignClient {
    @RequestMapping(value = SharedFoodEndpoint.FOODS, method = RequestMethod.GET)
    ResponseEntity<ResponseModel<List<SharedFood>>> getFoods();
    @RequestMapping(value = SharedFoodEndpoint.FOODS_ID, method = RequestMethod.GET)
    ResponseEntity<ResponseModel<SharedFood>> getFood(@PathVariable UUID id);
    @RequestMapping(value = SharedIngredientEndpoint.INGREDIENTS, method = RequestMethod.GET)
    ResponseEntity<ResponseModel<List<SharedIngredient>>> getIngredients();
    @RequestMapping(value = SharedIngredientEndpoint.INGREDIENTS_ID, method = RequestMethod.GET)
    ResponseEntity<ResponseModel<SharedIngredient>> getIngredient(@PathVariable UUID id);
    @RequestMapping(value = SharedCategoryEndpoints.CATEGORIES, method = RequestMethod.GET)
    ResponseEntity<ResponseModel<List<SharedCategory>>> getCategories();
    @RequestMapping(value = SharedCategoryEndpoints.CATEGORIES_ID, method = RequestMethod.GET)
    ResponseEntity<ResponseModel<SharedCategory>> getCategory(@PathVariable UUID id);
}
