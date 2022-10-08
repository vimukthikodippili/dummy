package com.example.demo.service;

import com.example.demo.dto.requestdto.RequestCatagoryDto;

public interface CatagoryService {
    String saveCatagory(RequestCatagoryDto dto, String prefix);
}
