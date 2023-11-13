package com.cihan.paymentreportservice.client.dto;

public record PSPTransactionListRequest(
        String fromDate,
        String toDate,
        String status,
        String operation,
        Integer merchantId,
        Integer acquirerId,
        String paymentMethod,
        String errorCode,
        String filterField,
        String filterValue,
        Integer page
) {
}

