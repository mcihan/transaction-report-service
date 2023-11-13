package com.cihan.transactionreportservice.controller.dto;

import com.cihan.transactionreportservice.domain.dto.ErrorCode;
import com.cihan.transactionreportservice.domain.dto.PaymentMethod;
import com.cihan.transactionreportservice.domain.dto.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record TransactionListRequest(

        @NotNull(message = "fromDate is mandatory")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @JsonFormat(pattern = "YYYY-MM-DD")
        LocalDate fromDate,

        @NotNull(message = "toDate is mandatory")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @JsonFormat(pattern = "YYYY-MM-DD")
        LocalDate toDate,
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