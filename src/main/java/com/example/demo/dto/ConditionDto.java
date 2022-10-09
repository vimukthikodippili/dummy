package com.example.demo.dto;

import com.example.demo.entity.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConditionDto {

    private String conditionId;
    private boolean conditions;
    private Products products;
}
