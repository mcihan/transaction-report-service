package com.cihan.transactionreportservice.client.dto;

import com.cihan.transactionreportservice.domain.dto.ErrorCode;
import com.cihan.transactionreportservice.domain.dto.PaymentMethod;
import com.cihan.transactionreportservice.domain.dto.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

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

