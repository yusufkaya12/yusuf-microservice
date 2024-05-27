package com.threepounds.baseservice.shared.shareduser;

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
public class SharedUserService {
    private final UserFeignClient userFeignClient;

    public ResponseModel<List<SharedUser>> user() {
        try {

            return userFeignClient.getUsers().getBody();
        } catch (FeignException fe) {
            if (fe.status() != HttpStatus.NOT_FOUND.value()) {
                log.error("Unable to get user users.", fe);
            }
            return null;
        }
    }

    public ResponseModel<SharedUser> getUserById(UUID id) {
        try {
            return userFeignClient.getUser(id).getBody();
        } catch (FeignException fe) {
            if (fe.status() != HttpStatus.NOT_FOUND.value()) {
                log.error("Unable to get user user.", fe);
            }
            return null;
        }
    }
}
