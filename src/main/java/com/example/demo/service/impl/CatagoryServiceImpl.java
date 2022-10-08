package com.example.demo.service.impl;

import com.example.demo.dto.CatagoryDto;
import com.example.demo.dto.core.GeneratedIdentificationDTO;
import com.example.demo.dto.requestdto.RequestCatagoryDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repo.CatagoryRepo;
import com.example.demo.service.CatagoryService;
import com.example.demo.util.Generator;
import com.example.demo.util.mapper.CatagoryMapper;
import org.springframework.stereotype.Service;

@Service
public class CatagoryServiceImpl implements CatagoryService {
    private final Generator generator;
    private final CatagoryRepo catagoryRepo;
    private final CatagoryMapper catagoryMapper;

    public CatagoryServiceImpl(Generator generator, CatagoryRepo catagoryRepo, CatagoryMapper catagoryMapper) {
        this.generator = generator;
        this.catagoryRepo = catagoryRepo;
        this.catagoryMapper = catagoryMapper;
    }

    @Override
    public String saveCatagory(RequestCatagoryDto dto, String prefix) {
        String catagoryCode = generator.createCatagoryCode(prefix);
        GeneratedIdentificationDTO generatedIdentificationData = generator.createId();
        CatagoryDto catagoryDto = new  CatagoryDto(
                generatedIdentificationData.getPrefix() + "-C-" + generatedIdentificationData.getId(),
                dto.getCatagoryName(),
        catagoryCode.length());






        if (!catagoryRepo.existsById(catagoryDto.getCatagoryId())) {
            return catagoryRepo.save(catagoryMapper.toCatagory(catagoryDto)).getCatagoryId();
        } else {
            throw new NotFoundException("Already Exists");
        }
    }
}
