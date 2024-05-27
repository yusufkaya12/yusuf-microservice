package com.threepounds.cityservice.controller;

import com.threepounds.baseservice.common.ResponseModel;
import com.threepounds.cityservice.controller.dto.CitiesDto;
import com.threepounds.cityservice.controller.mapper.CityMapper;
import com.threepounds.cityservice.controller.resource.CityResource;
import com.threepounds.cityservice.data.entity.City;
import com.threepounds.cityservice.data.entity.County;
import com.threepounds.baseservice.common.exceptions.NotFoundException;
import com.threepounds.cityservice.service.CitiesService;
import com.threepounds.cityservice.service.CountiesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cities")
public class CityController {
    private final CitiesService citiesService;
    private final CityMapper cityMapper;
    private final CountiesService countiesService;




    public CityController(CitiesService citiesService, CityMapper cityMapper, CountiesService countiesService) {
        this.citiesService = citiesService;
        this.cityMapper = cityMapper;
        this.countiesService = countiesService;

    }

    @GetMapping("")
    public ResponseModel<List<CityResource>> getCities() {
        List<City> cities = citiesService.list();

        List<CityResource> cityResources = cityMapper.resourceListToEntity(cities);
        return new ResponseModel<>(HttpStatus.OK.value(), cityResources, null);
    }

    @DeleteMapping("/{id}")
    public ResponseModel<String> deleteCity(@PathVariable UUID id) {
        citiesService.delete(id);
        return new ResponseModel<>(HttpStatus.OK.value(), "City removed", null);
    }

    @PostMapping("")
    public ResponseModel<CityResource> saveCity(@RequestBody CitiesDto citiesDto) {
        City saveCities = cityMapper.dtoToEntity(citiesDto);
        List<County> counties = countiesService.listById(citiesDto.getCounties());
        saveCities.setCounties(counties);
        City savedCities = citiesService.save(saveCities);
        CityResource cityResource = cityMapper.resourceToEntity(savedCities);
        return new ResponseModel<>(HttpStatus.OK.value(), cityResource, null);
    }

    @GetMapping("/{id}")
    public ResponseModel<CityResource> getCityById(@PathVariable UUID id) {
        City city = citiesService.getCity(id)
                .orElseThrow(() -> new NotFoundException("City Not Found"));
        CityResource cityResource = cityMapper.resourceToEntity(city);
        return new ResponseModel<>(HttpStatus.OK.value(), cityResource, null);
    }

}
