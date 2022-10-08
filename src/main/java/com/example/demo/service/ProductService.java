package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.requestdto.RequestProductDto;
import com.example.demo.dto.responsedto.ResponseProductDto;

import java.util.List;

public interface ProductService {
    String saveProduct( RequestProductDto dto);

    List<ResponseProductDto> getAllProduct(String searchText);
}
