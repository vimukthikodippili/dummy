package com.example.demo.dto;

import com.example.demo.enums.Types;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {


    private String productId;
    private int code;
    private boolean conditions;
    private double values;
    private Types types;
    private ArrayList validators;
    private String label;




}
