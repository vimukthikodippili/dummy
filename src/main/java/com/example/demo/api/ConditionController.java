package com.example.demo.api;

import com.example.demo.dto.requestdto.RequestCatagoryDto;
import com.example.demo.dto.requestdto.RequestConditionDto;
import com.example.demo.service.CatagoryService;
import com.example.demo.service.ConditionService;
import com.example.demo.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/condition")
@CrossOrigin
public class ConditionController {
    private final Logger LOGGER = LoggerFactory.getLogger(ConditionController.class);
    private final ConditionService conditionService;
    public ConditionController(ConditionService conditionService) {
        this.conditionService = conditionService;
    }
    @PostMapping(path = {"member/business/create-condition"}
            )
    public ResponseEntity<StandardResponse> savecondition(@RequestBody RequestConditionDto dto, @RequestParam(value = "productId") String productId) {

        String id = conditionService.saveCondition(dto,productId);
        return new ResponseEntity(new StandardResponse(201, id + " Success added", id),
                HttpStatus.CREATED);
    }


}
