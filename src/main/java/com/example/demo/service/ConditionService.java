package com.example.demo.service;

import com.example.demo.dto.requestdto.RequestConditionDto;

public interface ConditionService {
    String saveCondition(RequestConditionDto dto, String productId);
}
