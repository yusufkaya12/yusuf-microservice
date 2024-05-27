package com.threepounds.restaurantservice.data.repository;

import com.threepounds.restaurantservice.data.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MenuRepository extends JpaRepository<Menu, UUID> {
}
