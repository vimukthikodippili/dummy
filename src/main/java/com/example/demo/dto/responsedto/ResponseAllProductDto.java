package com.example.demo.dto.responsedto;

import com.example.demo.enums.Types;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAllProductDto {
    private String productId;
    private int conditions;
    private Array values;
    private Types types;
    private Array validators;
    private String label;
    private String brandLabel;
    private int required;
    private String toolTip;
    private int code;
}
