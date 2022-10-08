package com.example.demo.dto.requestdto;

import com.example.demo.enums.Types;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RequestProductDto {
    private int code;
    private boolean conditions;
    private double values;
    private Types types;
    private ArrayList validators;
    private String label;
}
