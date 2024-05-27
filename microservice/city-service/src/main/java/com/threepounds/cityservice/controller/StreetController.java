package com.threepounds.cityservice.controller;
import com.threepounds.baseservice.common.ResponseModel;
import com.threepounds.cityservice.controller.dto.StreetsDto;
import com.threepounds.cityservice.controller.mapper.StreetsMapper;
import com.threepounds.cityservice.controller.resource.StreetResource;
import com.threepounds.cityservice.data.entity.Street;
import com.threepounds.baseservice.common.exceptions.NotFoundException;
import com.threepounds.cityservice.service.StreetsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/streets")
public class StreetController {
    private final StreetsService streetsService;
    private final StreetsMapper streetsMapper;

    public StreetController(StreetsService streetsService, StreetsMapper streetsMapper) {
        this.streetsService = streetsService;
        this.streetsMapper = streetsMapper;
    }

    @GetMapping("")
    public ResponseModel<List<StreetResource>> getStreets() {
        List<Street> streets = streetsService.list();
        List<StreetResource> streetResources = streetsMapper.resourceListToEntity(streets);
        return new ResponseModel<>(HttpStatus.OK.value(), streetResources, null);
    }

    @GetMapping("/{id}")
    public ResponseModel<StreetResource> getOneStreet(@PathVariable UUID id) {
        Street street = streetsService.getStreet(id)
                .orElseThrow(() -> new NotFoundException("Street Not Found"));
        StreetResource streetResource = streetsMapper.resourceToEntity(street);
        return new ResponseModel<>(HttpStatus.OK.value(), streetResource, null);
    }

    @DeleteMapping("/{id}")
    public ResponseModel<String> deleteStreet(@PathVariable UUID id) {
        streetsService.delete(id);
        return new ResponseModel<>(HttpStatus.OK.value(), "Street Removed", null);
    }

    @PostMapping("")
    public ResponseModel<StreetResource> saveStreet(@RequestBody StreetsDto streetsDto) {
        Street saveStreets = streetsMapper.dtoToEntity(streetsDto);
        Street savedStreets = streetsService.save(saveStreets);
        StreetResource streetResource = streetsMapper.resourceToEntity(savedStreets);
        return new ResponseModel<>(HttpStatus.OK.value(), streetResource, null);
    }
}
