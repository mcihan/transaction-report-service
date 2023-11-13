package com.cihan.paymentreportservice.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TransactionListData(
        Fx fx,
        TransactionListCustomer customerInfo,
        @JsonProperty("updated_at")
        String updatedAt,
        @JsonProperty("created_at")
        String createdAt,
        Acquirer acquirer,
        Transaction transaction,
        Boolean refundable,
        Merchant merchant,
        Ipn ipn
) {
}

