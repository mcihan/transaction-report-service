package com.cihan.paymentreportservice.domain.dto;

public record Acquirer(
        Integer id,
        String name,
        String code,
        String type
) {
}
