package com.example.demo.util.mapper;

import com.example.demo.dto.CatagoryDto;
import com.example.demo.entity.Catagory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CatagoryMapper {
    Catagory toCatagory(CatagoryDto catagoryDto);
}
