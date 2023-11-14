package com.cihan.transactionreportservice.client.dto;

import lombok.Builder;

@Builder
public record PSPTransactionReportRequest(
        String fromDate,
        String toDate,
        Integer merchant,
        Integer acquirer) {

}
