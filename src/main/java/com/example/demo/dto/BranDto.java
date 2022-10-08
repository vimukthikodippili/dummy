package com.example.demo.dto;

import com.example.demo.entity.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranDto {

    private String brandId;
    private String label;
    private boolean required;
    private String toolTip;
    private int code;
    private ProductDto  product;

}
