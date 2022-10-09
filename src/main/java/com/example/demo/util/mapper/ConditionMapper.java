package com.example.demo.util.mapper;

import com.example.demo.dto.ConditionDto;
import com.example.demo.entity.Conditon;
import com.example.demo.repo.ConditionRepo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConditionMapper {
    Conditon toCondition(ConditionDto conditionDto);
}
