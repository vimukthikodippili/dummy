package com.example.demo.util.mapper;

import com.example.demo.dto.EditionDto;
import com.example.demo.entity.Edition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EditionMapper {
    Edition toEdition(EditionDto conditionDto);
}
