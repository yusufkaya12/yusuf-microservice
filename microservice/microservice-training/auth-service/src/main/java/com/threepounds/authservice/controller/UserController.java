package com.threepounds.authservice.controller;


import com.threepounds.authservice.controller.mapper.UserMapper;
import com.threepounds.authservice.controller.resource.UserResource;
import com.threepounds.authservice.data.entity.User;
import com.threepounds.authservice.service.UserService;
import com.threepounds.baseservice.common.ResponseModel;
import com.threepounds.baseservice.common.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;

    }

    @GetMapping
  public Object hello(Authentication authentication) {
    Object principal = authentication.getPrincipal();
    return principal;
  }


  @GetMapping("/list")
  public ResponseModel<List<UserResource>> list(Authentication authentication) {
      List<User> list = userService.findAll();
      List<UserResource> userResources = userMapper.listResourceToEntity(list);
      return new ResponseModel<>(HttpStatus.OK.value(), userResources, null);
  }

    @GetMapping("/{id}")
    public ResponseModel<UserResource> getById(@PathVariable UUID id) {
        User user = userService.getById(id)
                .orElseThrow(() -> new NotFoundException("User Not Found"));
        UserResource userResource = userMapper.resourceToEntity(user);
        return new ResponseModel<>(HttpStatus.OK.value(), userResource, null);
    }
}