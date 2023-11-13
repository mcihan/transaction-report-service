package com.cihan.transactionreportservice.controller.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest (
        @NotBlank
        @Max(128)
        String email,

        @NotBlank
        @Max(32)
        String password
){}

