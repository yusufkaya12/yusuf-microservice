package com.threepounds.orderservice.controller.mapper;

import com.threepounds.baseservice.shared.sharedfood.SharedFood;
import com.threepounds.baseservice.shared.sharedfood.SharedFoodService;
import com.threepounds.baseservice.shared.sharedrestaurant.SharedRestaurant;
import com.threepounds.baseservice.shared.sharedrestaurant.SharedRestaurantService;
import com.threepounds.baseservice.shared.shareduser.SharedUser;
import com.threepounds.baseservice.shared.shareduser.SharedUserService;
import com.threepounds.orderservice.controller.dto.OrderDto;
import com.threepounds.orderservice.controller.resource.OrderResource;
import com.threepounds.orderservice.data.entity.Order;
import jakarta.inject.Inject;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {
    @Inject
    private SharedRestaurantService sharedRestaurantService;
    @Inject
    private SharedUserService sharedUserService;
    @Inject
    private SharedFoodService sharedFoodService;

    @Mapping(target = "foodId", source = "foodId", ignore = true)
    public abstract Order dtoToEntity(OrderDto orderDto);

    public abstract OrderResource entityToResource(Order order);

    public abstract List<OrderResource> listEntityToListResource(List<Order> orders);

    @AfterMapping
    void afterRestaurantResourceMapping(Order order, @MappingTarget OrderResource orderResource) {
        SharedRestaurant restaurant = sharedRestaurantService.getRestaurantById(order.getRestaurantId()).getBody();
        orderResource.setSharedRestaurant(restaurant);
    }

    @AfterMapping
    void afterUserResourceMapping(Order order, @MappingTarget OrderResource orderResource) {
        SharedUser user = sharedUserService.getUserById(order.getUserId()).getBody();
        orderResource.setSharedUser(user);
    }

    @AfterMapping
    void afterFoodResourceMapping(Order order, @MappingTarget OrderResource orderResource) {
        if (!CollectionUtils.isEmpty(order.getFoodId())) {
            List<SharedFood> sharedFoods = order.getFoodId().stream().map(s ->
                    sharedFoodService.getFoodById(s).getBody()).collect(Collectors.toList());
            orderResource.setSharedFood(sharedFoods);

        }

    }

}
