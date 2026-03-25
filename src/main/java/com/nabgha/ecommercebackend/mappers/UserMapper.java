package com.nabgha.ecommercebackend.mappers;

import com.nabgha.ecommercebackend.dtos.UserDto;
import com.nabgha.ecommercebackend.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
