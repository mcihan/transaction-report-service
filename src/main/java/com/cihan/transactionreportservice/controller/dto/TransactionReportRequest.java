package com.cihan.transactionreportservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Schema
public record TransactionReportRequest(
        @NotNull(message = "fromDate is mandatory")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @JsonFormat(pattern = "YYYY-MM-DD")
        @Schema( type = "string", example = "2016-01-01")
        LocalDate fromDate,

        @NotNull(message = "toDate is mandatory")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @JsonFormat(pattern = "YYYY-MM-DD")
        @Schema( type = "string", example = "2023-11-13")
        LocalDate toDate,

        @Min(1)
        Integer merchant,
        @Min(1)
        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        Integer acquirer) {
}