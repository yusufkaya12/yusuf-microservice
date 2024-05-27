package com.threepounds.authservice.controller.mapper;

import com.threepounds.authservice.controller.resource.UserResource;
import com.threepounds.authservice.data.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface UserMapper {
    UserResource resourceToEntity(User user);

    List<UserResource> listResourceToEntity(List<User> user);

}
