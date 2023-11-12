package com.cihan.paymentreportservice.client.dto;

public record PSPTransactionReportRequest(
        String fromDate,
        String toDate,
        Integer merchant,
        Integer acquirer) {

}
