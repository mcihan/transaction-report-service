package com.cihan.transactionreportservice.client.response;

import com.cihan.transactionreportservice.domain.dto.TransactionReportData;
import lombok.Builder;

import java.util.List;

@Builder
public record PSPTransactionReportResponse(
        String status,
        List<TransactionReportData> response) {
}


