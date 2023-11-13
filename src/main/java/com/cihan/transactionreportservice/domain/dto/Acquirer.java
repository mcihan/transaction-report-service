package com.cihan.transactionreportservice.domain.dto;

public record Acquirer(
        Integer id,
        String name,
        String code,
        String type
) {
}
