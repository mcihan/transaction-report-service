package com.cihan.transactionreportservice.controller.dto;

public record TransactionReportRequest(
        String fromDate,
        String toDate,
        Integer merchant,
        Integer acquirer) {

}