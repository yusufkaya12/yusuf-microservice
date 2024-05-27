package com.threepounds.restaurantservice.controller;

import com.threepounds.baseservice.common.exceptions.NotFoundException;
import com.threepounds.baseservice.shared.sharedfood.SharedCategoryService;
import com.threepounds.baseservice.shared.sharedfood.SharedFoodService;
import com.threepounds.baseservice.shared.sharedfood.SharedIngredientService;
import com.threepounds.restaurantservice.controller.dto.MenuDto;
import com.threepounds.restaurantservice.controller.mapper.MenuMapper;
import com.threepounds.restaurantservice.controller.resource.MenuResource;
import com.threepounds.restaurantservice.controller.response.ResponseModel;
import com.threepounds.restaurantservice.data.entity.Menu;
import com.threepounds.restaurantservice.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    private final MenuMapper menuMapper;
    private final SharedFoodService sharedFoodService;
    private final SharedCategoryService sharedCategoryService;
    private final SharedIngredientService sharedIngredientService;

    public MenuController(MenuService menuService, MenuMapper menuMapper, SharedFoodService sharedFoodService, SharedCategoryService sharedCategoryService, SharedIngredientService sharedIngredientService) {
        this.menuService = menuService;
        this.menuMapper = menuMapper;
        this.sharedFoodService = sharedFoodService;
        this.sharedCategoryService = sharedCategoryService;
        this.sharedIngredientService = sharedIngredientService;
    }

    @PostMapping("/")
    public ResponseModel<MenuResource> create(@RequestBody MenuDto menuDto) {
        Menu saveToMenu = menuMapper.dtoToEntity(menuDto);
        saveToMenu.setFoodId(menuDto.getFoodId());
        menuService.save(saveToMenu);
        MenuResource menuResource = menuMapper.resourceToEntity(saveToMenu);
        return new ResponseModel<>(HttpStatus.OK.value(), menuResource, null);
    }

    @GetMapping("/")
    public ResponseModel<List<MenuResource>> getAll() {
        List<Menu> menus = menuService.list();
        List<MenuResource> menuResources = menuMapper.listResourceToEntity(menus);
        return new ResponseModel<>(HttpStatus.OK.value(), menuResources, null);
    }

    @GetMapping("/{id}")
    public ResponseModel<MenuResource> getMenuById(@PathVariable UUID id) {
        Menu menu = menuService.getById(id).orElseThrow(() -> new NotFoundException("Menu Not Found"));
        MenuResource menuResource = menuMapper.resourceToEntity(menu);
        return new ResponseModel<>(HttpStatus.OK.value(), menuResource, null);
    }


}
