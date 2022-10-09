package com.example.demo.service;

import com.example.demo.dto.requestdto.RequestConditionDto;
import com.example.demo.dto.requestdto.RequestEditionDto;

public interface EditionService{


    String saveEdition(RequestEditionDto dto, String productId);
}