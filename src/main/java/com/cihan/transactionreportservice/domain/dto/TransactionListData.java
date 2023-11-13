package com.cihan.transactionreportservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TransactionListData(
        Fx fx,
        TransactionListCustomer customerInfo,
        @JsonProperty("updatedAt")
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

