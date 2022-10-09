package com.example.demo.service.impl;

import com.example.demo.dto.ConditionDto;
import com.example.demo.dto.EditionDto;
import com.example.demo.dto.core.GeneratedIdentificationDTO;
import com.example.demo.dto.requestdto.RequestConditionDto;
import com.example.demo.dto.requestdto.RequestEditionDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repo.EditionRepo;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.EditionService;
import com.example.demo.util.Generator;
import com.example.demo.util.mapper.EditionMapper;
import com.example.demo.util.mapper.ProductMapper;
import org.springframework.stereotype.Service;

@Service
public class EditionServiceImpl implements EditionService {
    private final Generator generator;
    private final EditionRepo editionRepo;
    private final EditionMapper editionMapper;
    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    public EditionServiceImpl(Generator generator, EditionRepo editionRepo, EditionMapper editionMapper, ProductRepo productRepo, ProductMapper productMapper) {
        this.generator = generator;
        this.editionRepo = editionRepo;
        this.editionMapper = editionMapper;
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }

    @Override
    public String saveEdition(RequestEditionDto dto, String productId) {
        GeneratedIdentificationDTO generatedIdentificationDTO = generator.createId();
        EditionDto conditionDto = new EditionDto(
                generatedIdentificationDTO.getPrefix() + "-CR-" + generatedIdentificationDTO.getId(),
                dto.getTypes(),
                productMapper.toProductDto1(productRepo.findById(productId).get())
        );

        if (!editionRepo.existsById(conditionDto.getEditionId())) {
            return editionRepo.save(editionMapper.toEdition(conditionDto)).getEditionId();
        } else {
            throw new NotFoundException("Already Exists");
        }
    }
}
