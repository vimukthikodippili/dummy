package com.example.demo.dto.responsedto;

import com.example.demo.enums.Types;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProductDto {
    private String productId;
    private int conditions;
    private double values;
    private Types types;
    private ArrayList validators;
    private String label;
    private String brandLabel;
    private int required;
    private String toolTip;
    private int code;
}
