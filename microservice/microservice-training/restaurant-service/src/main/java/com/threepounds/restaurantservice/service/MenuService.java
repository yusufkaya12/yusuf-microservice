package com.threepounds.restaurantservice.service;

import com.threepounds.restaurantservice.data.entity.Menu;
import com.threepounds.restaurantservice.data.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MenuService {
    private final MenuRepository menuRepository;


    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;

    }

    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    public List<Menu> list() {
        return menuRepository.findAll();
    }

    public Optional<Menu> getById(UUID id) {
        return menuRepository.findById(id);
    }

}
