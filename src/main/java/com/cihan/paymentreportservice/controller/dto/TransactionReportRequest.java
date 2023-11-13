package com.cihan.paymentreportservice.controller.dto;

public record TransactionReportRequest(
        String fromDate,
        String toDate,
        Integer merchant,
        Integer acquirer) {

}