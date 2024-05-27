package com.threepounds.cityservice.controller.mapper;

import com.threepounds.cityservice.controller.dto.StreetsDto;
import com.threepounds.cityservice.controller.resource.StreetResource;
import com.threepounds.cityservice.data.entity.Street;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StreetsMapper {
    Street dtoToEntity(StreetsDto streetsDto);

    StreetResource resourceToEntity(Street streets);

    List<StreetResource> resourceListToEntity(List<Street> streets);
}
