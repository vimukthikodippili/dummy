package com.example.demo.service.impl;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.core.GeneratedIdentificationDTO;
import com.example.demo.dto.requestdto.RequestProductDto;
import com.example.demo.dto.responsedto.ResponseProductDto;
import com.example.demo.entity.Products;
import com.example.demo.entity.customerInterface.ProductInterface;
import com.example.demo.enums.Types;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repo.CatagoryRepo;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ProductService;
import com.example.demo.util.Generator;
import com.example.demo.util.mapper.CatagoryMapper;
import com.example.demo.util.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final Generator generator;
    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    public ProductServiceImpl(Generator generator, ProductRepo productRepo, ProductMapper productMapper) {
        this.generator = generator;
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }



    @Override
    public String saveProduct(RequestProductDto dto) {
        GeneratedIdentificationDTO generatedIdentificationData = generator.createId();
        ProductDto productDto=new ProductDto(
                generatedIdentificationData.getPrefix() + "-C-" + generatedIdentificationData.getId(),
        dto.getCode(),
        dto.isConditions(),
        dto.getValues(),
        dto.getTypes(),
        dto.getValidators(),
                dto.getLabel());
        if (!productRepo.existsById(productDto.getProductId())) {
            return productRepo.save(productMapper.toProduct(productDto)).getProductId();
        } else {
            throw new NotFoundException("Already Exists");
        }
    }

    @Override
    public List<ResponseProductDto> getAllProduct(String searchText) {
        List<ProductInterface> getAll = productRepo.getAllProduct(searchText);
        return productMapper.toResponseProductDtoList(getAll);
    }
}
