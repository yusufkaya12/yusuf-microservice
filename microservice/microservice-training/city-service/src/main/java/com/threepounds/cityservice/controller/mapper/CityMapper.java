package com.threepounds.cityservice.controller.mapper;

import com.threepounds.cityservice.controller.dto.CitiesDto;
import com.threepounds.cityservice.controller.resource.CityResource;
import com.threepounds.cityservice.data.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface CityMapper {
    @Mapping(source = "counties", target = "counties", ignore = true)
    City dtoToEntity(CitiesDto citiesDto);

    CityResource resourceToEntity(City cities);

    @Mapping(source = "counties", target = "counties", ignore = true)
    List<CityResource> resourceListToEntity(List<City> cities);
}
