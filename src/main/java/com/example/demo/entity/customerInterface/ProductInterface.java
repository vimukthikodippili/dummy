package com.example.demo.entity.customerInterface;

import com.example.demo.enums.Types;

import java.util.ArrayList;

public interface ProductInterface {
     String getProductId();
   Double getConditions();
     Double getValuess();
     Types getTypes();
    ArrayList getValidators();
     String getLabel();
    String getBrandLabel();
     Byte getRequired();
     String getToolTip();
    Integer getCode();
}
