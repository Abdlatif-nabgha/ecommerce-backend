package com.nabgha.ecommercebackend.mappers;

import com.nabgha.ecommercebackend.dtos.ProductDto;
import com.nabgha.ecommercebackend.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toDto(Product product);
}
