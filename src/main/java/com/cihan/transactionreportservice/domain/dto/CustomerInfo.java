package com.cihan.transactionreportservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record CustomerInfo(
        String billingFirstName,
        String billingLastName,
        String email,
        String billingCompany,
        String billingCity,
        @JsonProperty("updated_at")
        String updatedAt,
        @JsonProperty("created_at")
        String createdAt,
        Integer id,
        Object billingAddress1
) {
}
