package com.cihan.transactionreportservice.client.dto;

public record PSPTransactionReportRequest(
        String fromDate,
        String toDate,
        Integer merchant,
        Integer acquirer) {

}
