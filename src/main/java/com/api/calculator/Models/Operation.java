package com.api.calculator.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {

    private Double[] operands;
    private String operator;
    private Double result;
}
