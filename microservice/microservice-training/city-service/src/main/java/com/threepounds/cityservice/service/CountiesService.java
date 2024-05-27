package com.threepounds.cityservice.service;

import com.threepounds.cityservice.data.entity.County;
import com.threepounds.cityservice.data.repository.CountiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CountiesService {
    private final CountiesRepository countiesRepository;

    public CountiesService(CountiesRepository countiesRepository) {
        this.countiesRepository = countiesRepository;
    }

    public void delete(UUID id) {
        countiesRepository.deleteById(id);
    }

    public County save(County county) {
        return countiesRepository.save(county);
    }

    public List<County> list() {
        return countiesRepository.findAll();
    }

    public Optional<County> getCounty(UUID id) {
        return countiesRepository.findById(id);
    }

    public List<County> listById(List<UUID> counties) {
        return countiesRepository.findAllById(counties);
    }
}
