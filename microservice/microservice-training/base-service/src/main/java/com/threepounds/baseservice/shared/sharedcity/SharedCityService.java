package com.threepounds.baseservice.shared.sharedcity;


import com.threepounds.baseservice.common.ResponseModel;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
@Component
public class SharedCityService {

  private final CityFeignClient cityFeignClient;


  public ResponseModel<List<SharedCity>> cities() {
    try {
      return cityFeignClient.getCities().getBody();
    } catch (FeignException fe) {
      if (fe.status() != HttpStatus.NOT_FOUND.value()) {
        log.error("Unable to get user cities.", fe);
      }
      return null;
    }
  }


  public ResponseModel<SharedCity> getCityById(UUID id) {

    try {

      return cityFeignClient.getCity(id).getBody();


    } catch (FeignException fe) {
      if (fe.status() != HttpStatus.NOT_FOUND.value()) {
        log.error("Unable to get user city", fe);
      }

      return null;

    }

  }

}
