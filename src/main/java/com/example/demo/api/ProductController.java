package com.example.demo.api;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.requestdto.RequestCatagoryDto;
import com.example.demo.dto.requestdto.RequestProductDto;
import com.example.demo.dto.responsedto.ResponseProductDto;
import com.example.demo.service.CatagoryService;
import com.example.demo.service.ProductService;
import com.example.demo.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin
public class ProductController {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping(path = {"member/business/create-catagory"})
    public ResponseEntity<StandardResponse> saveCatagory(@RequestBody RequestProductDto dto) {

        String id = productService.saveProduct(dto);
        return new ResponseEntity(new StandardResponse(201, id + " Success added", id),
                HttpStatus.CREATED);
    }
    @GetMapping(
            path = "/main/visco/get-brand")
    public ResponseEntity<StandardResponse> allBrandByNameAndId(
            @RequestParam(value = "searchText", defaultValue = "", required = false) String searchText
    ) {
        List<ResponseProductDto> dto = productService.getAllProduct(searchText);
        return new ResponseEntity(new StandardResponse(200, "Success", dto), HttpStatus.OK);

    }


}
