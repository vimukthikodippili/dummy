package com.example.demo.service.impl;

import com.example.demo.dto.BranDto;
import com.example.demo.dto.ConditionDto;
import com.example.demo.dto.core.GeneratedIdentificationDTO;
import com.example.demo.dto.requestdto.RequestConditionDto;
import com.example.demo.entity.Products;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repo.ConditionRepo;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ConditionService;
import com.example.demo.util.Generator;
import com.example.demo.util.mapper.ConditionMapper;
import com.example.demo.util.mapper.ProductMapper;
import org.springframework.stereotype.Service;

@Service
public class ConditionServiceImpl implements ConditionService {
    private final Generator generator;
    private final ConditionRepo conditionRepo;
    private final ConditionMapper conditionMapper;
    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    public ConditionServiceImpl(Generator generator, ConditionRepo conditionRepo, ConditionMapper conditionMapper, ProductRepo productRepo, ProductMapper productMapper) {
        this.generator = generator;
        this.conditionRepo = conditionRepo;
        this.conditionMapper = conditionMapper;
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }

    @Override
    public String saveCondition(RequestConditionDto dto, String productId) {
        GeneratedIdentificationDTO generatedIdentificationDTO = generator.createId();
        ConditionDto conditionDto = new ConditionDto(
                generatedIdentificationDTO.getPrefix() + "-CR-" + generatedIdentificationDTO.getId(),
                dto.isConditions(),
                productMapper.toProductDto1(productRepo.findById(productId).get())
        );

        if (!conditionRepo.existsById(conditionDto.getConditionId())) {
            return conditionRepo.save(conditionMapper.toCondition(conditionDto)).getConditionId();
        } else {
            throw new NotFoundException("Already Exists");
        }
    }
}
