package com.nabgha.ecommercebackend.mappers;

import com.nabgha.ecommercebackend.dtos.CartDto;
import com.nabgha.ecommercebackend.dtos.CartItemDto;
import com.nabgha.ecommercebackend.entities.Cart;
import com.nabgha.ecommercebackend.entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(target = "totalPrice", expression = "java(cart.getTotalPrice())")
    CartDto toDto(Cart cart);
    @Mapping(target = "totalPrice", expression = "java(cartItem.getTotalPrice())")
    CartItemDto toDto(CartItem cartItem);
}
