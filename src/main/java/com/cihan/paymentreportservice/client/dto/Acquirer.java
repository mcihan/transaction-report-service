package com.cihan.paymentreportservice.client.dto;

public record Acquirer(
        Integer id,
        String name,
        String code,
        String type
) {
}
