package com.example.demo.api;

import com.example.demo.dto.requestdto.RequestCatagoryDto;
import com.example.demo.service.CatagoryService;
import com.example.demo.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin
public class CatagoryController {
    private final Logger LOGGER = LoggerFactory.getLogger(CatagoryController.class);
    private final CatagoryService catagoryService;

    public CatagoryController(CatagoryService catagoryService) {
        this.catagoryService = catagoryService;
    }
    @PostMapping(path = {"member/business/create-catagory"},
            params = {"prefix"})
    public ResponseEntity<StandardResponse> saveCatagory(@RequestBody RequestCatagoryDto dto,@RequestParam(value = "prefix") String prefix) {

        String id = catagoryService.saveCatagory(dto,prefix);
        return new ResponseEntity(new StandardResponse(201, id + " Success added", id),
                HttpStatus.CREATED);
    }


}
