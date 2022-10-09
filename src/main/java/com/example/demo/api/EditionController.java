package com.example.demo.api;

import com.example.demo.dto.requestdto.RequestConditionDto;
import com.example.demo.dto.requestdto.RequestEditionDto;
import com.example.demo.service.ConditionService;
import com.example.demo.service.EditionService;
import com.example.demo.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/edition")
@CrossOrigin
public class EditionController {
    private final Logger LOGGER = LoggerFactory.getLogger(EditionController.class);
    private final EditionService editionService;

    public EditionController(EditionService editionService) {
        this.editionService = editionService;
    }
    @PostMapping(path = {"member/business/create-edition"}
    )
    public ResponseEntity<StandardResponse> savecondition(@RequestBody RequestEditionDto dto, @RequestParam(value = "productId") String productId) {

        String id = editionService.saveEdition(dto,productId);
        return new ResponseEntity(new StandardResponse(201, id + " Success added", id),
                HttpStatus.CREATED);
    }
}
