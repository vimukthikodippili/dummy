package com.example.demo.dto.requestdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestBrandDto {

    private String label;
    private String toolTip;
    private int code;
}
