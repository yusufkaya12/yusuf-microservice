package com.threepounds.restaurantservice.controller.mapper;

import com.threepounds.baseservice.shared.sharedfood.SharedFood;
import com.threepounds.baseservice.shared.sharedfood.SharedFoodService;
import com.threepounds.restaurantservice.controller.dto.MenuDto;
import com.threepounds.restaurantservice.controller.resource.MenuResource;
import com.threepounds.restaurantservice.data.entity.Menu;
import jakarta.inject.Inject;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class MenuMapper {
    @Inject
    private SharedFoodService sharedFoodService;


    @Mapping(target = "foodId", source = "foodId", ignore = true)
    public abstract Menu dtoToEntity(MenuDto menuDto);

    public abstract MenuResource resourceToEntity(Menu menu);

    @Mapping(target = "sharedFoods", source = "sharedFoods")
    public abstract List<MenuResource> listResourceToEntity(List<Menu> menu);

    @AfterMapping
    void afterResourceMapping(Menu menu, @MappingTarget MenuResource menuResource) {
        if (!CollectionUtils.isEmpty(menu.getFoodId())) {
            List<SharedFood> sharedFood = menu.getFoodId().stream().map(s ->
                    sharedFoodService.getFoodById(s).getBody()).collect(Collectors.toList());
            menuResource.setSharedFoods(sharedFood);
        }

    }

}
