package com.cihan.transactionreportservice.controller.dto;

import com.cihan.transactionreportservice.domain.dto.ErrorCode;
import com.cihan.transactionreportservice.domain.dto.PaymentMethod;
import com.cihan.transactionreportservice.domain.dto.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

public record TransactionListRequest(
        String fromDate,
        String toDate,
        Status status,
        String operation,
        Integer merchantId,
        Integer acquirerId,
        PaymentMethod paymentMethod,
        //@JsonProperty("errorCode")
        String errorCode,
        String filterField,
        String filterValue,
        Integer page
) {
}