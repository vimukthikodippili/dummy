package com.example.demo.dto;

import com.example.demo.entity.Products;
import com.example.demo.enums.Types;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditionDto {

    private String editionId;


    private Types types;


    private Products products;
}
