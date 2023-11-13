package com.cihan.paymentreportservice.controller.dto;

public record TransactionListRequest(
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