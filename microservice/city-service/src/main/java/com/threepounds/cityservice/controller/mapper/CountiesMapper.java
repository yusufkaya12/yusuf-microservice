package com.threepounds.cityservice.controller.mapper;

import com.threepounds.cityservice.controller.dto.CountiesDto;
import com.threepounds.cityservice.controller.resource.CountyResource;
import com.threepounds.cityservice.data.entity.County;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountiesMapper {
    @Mapping(source = "streets", target = "streets", ignore = true)
    County dtoToEntity(CountiesDto countiesDto);

    CountyResource resourceToEntity(County counties);

    @Mapping(source = "streets", target = "streets", ignore = true)
    List<CountyResource> resourceListToEntity(List<County> counties);
}
