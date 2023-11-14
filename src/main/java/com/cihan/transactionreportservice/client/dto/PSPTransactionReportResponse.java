package com.cihan.transactionreportservice.client.dto;

import com.cihan.transactionreportservice.domain.dto.TransactionReportData;
import lombok.Builder;

import java.util.List;

@Builder
public record PSPTransactionReportResponse(
        String status,
        List<TransactionReportData> response) {
}


