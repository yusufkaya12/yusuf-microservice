package com.threepounds.cityservice.controller;

import com.threepounds.baseservice.common.ResponseModel;
import com.threepounds.cityservice.controller.dto.CountiesDto;
import com.threepounds.cityservice.controller.mapper.CountiesMapper;
import com.threepounds.cityservice.controller.resource.CountyResource;
import com.threepounds.cityservice.data.entity.County;
import com.threepounds.cityservice.data.entity.Street;
import com.threepounds.baseservice.common.exceptions.NotFoundException;
import com.threepounds.cityservice.service.CountiesService;
import com.threepounds.cityservice.service.StreetsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/counties")
public class CountyController {
    private final CountiesService countiesService;
    private final CountiesMapper countiesMapper;
    private final StreetsService streetsService;


    public CountyController(CountiesService countiesService, CountiesMapper countiesMapper, StreetsService streetsService) {
        this.countiesService = countiesService;
        this.countiesMapper = countiesMapper;
        this.streetsService = streetsService;
    }

    @GetMapping("")
    public ResponseModel<List<CountyResource>> getCounties() {
        List<County> counties = countiesService.list();
        List<CountyResource> countyResources = countiesMapper.resourceListToEntity(counties);
        return new ResponseModel<>(HttpStatus.OK.value(), countyResources, null);
    }

    @GetMapping("/{id}")
    public ResponseModel<CountyResource> getOneCounty(@PathVariable UUID id) {
        County county = countiesService.getCounty(id)
                .orElseThrow(() -> new NotFoundException("County Not Found"));
        CountyResource countyResource = countiesMapper.resourceToEntity(county);
        return new ResponseModel<>(HttpStatus.OK.value(), countyResource, null);
    }

    @DeleteMapping("/{id}")
    public ResponseModel<String> deleteCounty(@PathVariable UUID id) {
        countiesService.delete(id);
        return new ResponseModel<>(HttpStatus.OK.value(), "County Removed", null);
    }

    @PostMapping("")
    public ResponseModel<CountyResource> saveCounty(@RequestBody CountiesDto countiesDto) {
        County saveCounties = countiesMapper.dtoToEntity(countiesDto);
        List<Street> streets = streetsService.listById(countiesDto.getStreets());
        saveCounties.setStreets(streets);
        County savedCounty = countiesService.save(saveCounties);
        CountyResource countyResource = countiesMapper.resourceToEntity(savedCounty);
        return new ResponseModel<>(HttpStatus.OK.value(), countyResource, null);
    }
}
