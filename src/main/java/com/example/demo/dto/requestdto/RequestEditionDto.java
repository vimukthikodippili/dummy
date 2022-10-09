package com.example.demo.dto.requestdto;

import com.example.demo.enums.Types;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestEditionDto {
    private Types types;
}
