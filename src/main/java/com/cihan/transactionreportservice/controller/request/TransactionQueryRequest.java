package com.cihan.transactionreportservice.controller.request;

import com.cihan.transactionreportservice.domain.dto.PaymentMethod;
import com.cihan.transactionreportservice.domain.dto.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Schema
public record TransactionQueryRequest(

        @NotNull(message = "fromDate is mandatory")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @JsonFormat(pattern = "YYYY-MM-DD")
        @Schema(type = "string", example = "2016-01-01")
        LocalDate fromDate,

        @NotNull(message = "toDate is mandatory")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @JsonFormat(pattern = "YYYY-MM-DD")
        @Schema(type = "string", example = "2023-11-13")
        LocalDate toDate,
        Status status,

        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        String operation,
        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        Integer merchantId,
        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        Integer acquirerId,
        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        PaymentMethod paymentMethod,
        //@JsonProperty("errorCode")
        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        String errorCode,
        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        String filterField,
        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        String filterValue,
        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        Integer page
) {
}