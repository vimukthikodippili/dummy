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
public class ResponseProductDto {
    private String label;
    private String Brandlabel;
    private int conditions;
    private String types;




}
