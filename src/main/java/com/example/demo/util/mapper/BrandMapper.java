package com.example.demo.util.mapper;

import com.example.demo.dto.BranDto;
import com.example.demo.entity.Brands;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    Brands toBrand(BranDto branDto);
}
