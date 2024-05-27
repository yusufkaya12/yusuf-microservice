package com.threepounds.cityservice.service;

import com.threepounds.cityservice.data.entity.Street;
import com.threepounds.cityservice.data.repository.StreetsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StreetsService {
    private final StreetsRepository streetsRepository;

    public StreetsService(StreetsRepository streetsRepository) {
        this.streetsRepository = streetsRepository;
    }

    public void delete(UUID id) {
        streetsRepository.deleteById(id);
    }

    public Street save(Street street) {
        return streetsRepository.save(street);
    }

    public Optional<Street> getStreet(UUID id) {
        return streetsRepository.findById(id);
    }

    public List<Street> list() {
        return streetsRepository.findAll();
    }

    public List<Street> listById(List<UUID> streets) {
        return streetsRepository.findAllById(streets);
    }
}
