package com.threepounds.cityservice.service;

import com.threepounds.cityservice.data.entity.City;
import com.threepounds.cityservice.data.repository.CitiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CitiesService {
    private final CitiesRepository citiesRepository;

    public CitiesService(CitiesRepository citiesRepository) {
        this.citiesRepository = citiesRepository;
    }

    public City save(City city) {
        return citiesRepository.save(city);
    }

    public void delete(UUID id) {
        citiesRepository.deleteById(id);
    }

    public List<City> list() {
        return citiesRepository.findAll();
    }

    public Optional<City> getCity(UUID id) {
        return citiesRepository.findById(id);
    }

}
