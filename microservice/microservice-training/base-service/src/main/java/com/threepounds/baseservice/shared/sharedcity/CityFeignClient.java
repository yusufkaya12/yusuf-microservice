package com.threepounds.baseservice.shared.sharedcity;


import com.threepounds.baseservice.common.ResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;


@FeignClient("city-service")
public interface CityFeignClient {

    @RequestMapping(value = SharedCityEndpoints.CITIES, method = RequestMethod.GET)
    ResponseEntity<ResponseModel<List<SharedCity>>> getCities();
    @RequestMapping(value = SharedCityEndpoints.CITY,method=RequestMethod.POST )
    ResponseEntity<ResponseModel<SharedCity>> createCity(@RequestBody SharedCity sharedCity);

  @RequestMapping(value = SharedCityEndpoints.CITIES_ID, method = RequestMethod.GET)
  ResponseEntity<ResponseModel<SharedCity>> getCity(@PathVariable UUID id);

  @RequestMapping(value = SharedCountyEndpoints.COUNTIES, method = RequestMethod.GET)
  ResponseEntity<ResponseModel<List<SharedCounty>>> getCounties();

  @RequestMapping(value = SharedCountyEndpoints.COUNTIES_ID, method = RequestMethod.GET)
  ResponseEntity<ResponseModel<SharedCounty>> getCounty(@PathVariable UUID id);

  @RequestMapping(value = SharedStreetEndpoints.STREETS, method = RequestMethod.GET)
  ResponseEntity<ResponseModel<List<SharedStreet>>> getStreets();

  @RequestMapping(value = SharedStreetEndpoints.STREET_ID, method = RequestMethod.GET)
  ResponseEntity<ResponseModel<SharedStreet>> getStreet(@PathVariable UUID id);
}
