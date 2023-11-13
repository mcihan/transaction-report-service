package com.cihan.transactionreportservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record TransactionReportRequest(
        @NotNull(message = "fromDate is mandatory")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @JsonFormat(pattern = "YYYY-MM-DD")
        LocalDate fromDate,

        @NotNull(message = "toDate is mandatory")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @JsonFormat(pattern = "YYYY-MM-DD")
        LocalDate toDate,
        Integer merchant,
        Integer acquirer) {
}