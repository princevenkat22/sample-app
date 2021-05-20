package com.m2p.sampleapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    @NotEmpty(message = "Input 1 is required")
    private double inp1;
    @NotEmpty(message = "Input 2 is required")
    private double inp2;
    @NotEmpty(message = "Operator is required")
    private char operator;
}
