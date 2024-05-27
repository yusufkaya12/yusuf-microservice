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
public class SharedCountyService {
    private final CityFeignClient cityFeignClient;



    public ResponseModel<SharedCounty>county(UUID id) {

        try {

            return cityFeignClient.getCounty(id).getBody();


        } catch (FeignException fe) {
            if (fe.status() != HttpStatus.NOT_FOUND.value()) {
                log.error("Unable to get user city", fe);
            }

            return null;

        }

    }
    public ResponseModel<List<SharedCounty>>counties(){
        try {
            return cityFeignClient.getCounties().getBody();
        }catch (FeignException fe){
            if(fe.status()!=HttpStatus.OK.NOT_FOUND.value()){
                log.error("Unable to get user counties");
            }
            return null;
        }
    }
}
