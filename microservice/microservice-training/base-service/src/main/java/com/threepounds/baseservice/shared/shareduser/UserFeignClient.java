package com.threepounds.baseservice.shared.shareduser;

import com.threepounds.baseservice.common.ResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@FeignClient("auth-service")
public interface UserFeignClient {
    @RequestMapping(value = SharedUserEndPoints.USER_ID, method = RequestMethod.GET)
    ResponseEntity<ResponseModel<SharedUser>> getUser(@PathVariable UUID id);

    @RequestMapping(value = SharedUserEndPoints.USERS, method = RequestMethod.GET)
    ResponseEntity<ResponseModel<List<SharedUser>>> getUsers();

}
