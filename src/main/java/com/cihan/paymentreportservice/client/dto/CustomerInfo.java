package com.cihan.paymentreportservice.client.dto;

public record CustomerInfo(
        String billingFirstName,
        String billingLastName,
        String email,
        String billingCompany,
        String billingCity,
        String updated_at,
        String created_at,
        Integer id,
        Object billingAddress1
) {
}
