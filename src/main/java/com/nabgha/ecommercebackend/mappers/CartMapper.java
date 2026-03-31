package com.nabgha.ecommercebackend.mappers;

import com.nabgha.ecommercebackend.dtos.CartDto;
import com.nabgha.ecommercebackend.entities.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartDto toDto(Cart cart);
}
