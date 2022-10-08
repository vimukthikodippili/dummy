package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatagoryDto {

    private String catagoryId;

    private String catagoryName;

    private int code;
}
