package com.example.demo.api;

import com.example.demo.dto.requestdto.RequestBrandDto;
import com.example.demo.dto.requestdto.RequestProductDto;
import com.example.demo.service.BrandService;
import com.example.demo.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/brand")
@CrossOrigin
public class BrandController {
    private final Logger LOGGER = LoggerFactory.getLogger(BrandController.class);

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

@PostMapping(
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        path = "member/business/save-brand")
public ResponseEntity<StandardResponse> saveBrand(
        @Valid @RequestBody RequestBrandDto dto,
        @RequestParam(value = "productId") String productId) {
    System.out.println("gfvhfh"+productId);
    String id = brandService.saveBrand(dto, productId);
    return new ResponseEntity<StandardResponse>(
            new StandardResponse(201, "Saved!", id),
            HttpStatus.CREATED);
}
}
