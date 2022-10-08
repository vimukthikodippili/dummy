package com.example.demo.service.impl;

import com.example.demo.api.BrandController;
import com.example.demo.dto.BranDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.core.GeneratedIdentificationDTO;
import com.example.demo.dto.requestdto.RequestBrandDto;
import com.example.demo.exception.EntryDuplicateException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repo.BrandRepo;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.BrandService;
import com.example.demo.util.Generator;
import com.example.demo.util.mapper.BrandMapper;
import com.example.demo.util.mapper.ProductMapper;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {
    private final Generator generator;
    private final BrandRepo brandRepo;
    private final BrandMapper brandMapper;
    private final ProductMapper productMapper;
    private final ProductRepo productRepo;

    public BrandServiceImpl(Generator generator, BrandRepo brandRepo, BrandMapper brandMapper, ProductMapper productMapper, ProductRepo productRepo) {
        this.generator = generator;
        this.brandRepo = brandRepo;
        this.brandMapper = brandMapper;
        this.productMapper = productMapper;
        this.productRepo = productRepo;
    }

    @Override
    public String saveBrand(RequestBrandDto dto,String productId) {

        GeneratedIdentificationDTO generatedIdentificationDTO = generator.createId();
        BranDto branDto = new BranDto(
                generatedIdentificationDTO.getPrefix() + "-CR-" + generatedIdentificationDTO.getId(),
                dto.getLabel(),
                true,
                dto.getToolTip(),
                dto.getCode(),
                productMapper.toProductDto(productRepo.findById(productId).get())
        );
        if (!brandRepo.existsById(branDto.getBrandId())) {
            return brandRepo.save(brandMapper.toBrand(branDto)).getBrandId();
        } else {
            throw new NotFoundException("Already Exists");
        }
    }






}
