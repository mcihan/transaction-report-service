package com.cihan.transactionreportservice.client.request;

import lombok.Builder;

@Builder
public record PSPTransactionReportRequest(
        String fromDate,
        String toDate,
        Integer merchant,
        Integer acquirer) {

}
