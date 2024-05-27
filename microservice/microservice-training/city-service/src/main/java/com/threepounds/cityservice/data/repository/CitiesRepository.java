package com.threepounds.cityservice.data.repository;

import com.threepounds.cityservice.data.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CitiesRepository extends JpaRepository<City, UUID> {
}
