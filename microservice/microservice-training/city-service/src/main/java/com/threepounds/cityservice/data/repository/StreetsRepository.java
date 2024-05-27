package com.threepounds.cityservice.data.repository;

import com.threepounds.cityservice.data.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StreetsRepository extends JpaRepository<Street, UUID> {
}
