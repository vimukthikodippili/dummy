package com.example.demo.service;

import com.example.demo.dto.requestdto.RequestBrandDto;

public interface BrandService {
    String saveBrand(RequestBrandDto dto,String productId);
}
