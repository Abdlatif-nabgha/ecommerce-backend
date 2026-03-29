package com.nabgha.ecommercebackend.mappers;

import com.nabgha.ecommercebackend.dtos.RegisterUserRequest;
import com.nabgha.ecommercebackend.dtos.UpdateUserRequest;
import com.nabgha.ecommercebackend.dtos.UserDto;
import com.nabgha.ecommercebackend.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequest request, @MappingTarget User user);
}
