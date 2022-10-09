package com.example.demo.util.mapper;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.responsedto.ResponseProductDto;
import com.example.demo.entity.Products;
import com.example.demo.entity.customerInterface.ProductInterface;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Products toProduct(ProductDto productDto);

    List<ResponseProductDto> toResponseProductDtoList(List<ProductInterface> getAll);

    ProductDto toProductDto(Products products);

    List<ResponseProductDto> toResponseProdducrDtoList(List<Products> getAll);

    Products toProductDto1(Products products);

    List<ResponseProductDto> toResponseProdducList(List<ProductInterface> getAll);

    //List<ResponseProductDto> toResponseProductDtoList1(List<ProductInterface> getAll);
}
