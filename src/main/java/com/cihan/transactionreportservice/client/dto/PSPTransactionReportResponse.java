package com.cihan.transactionreportservice.client.dto;

import com.cihan.transactionreportservice.domain.dto.TransactionReportData;
import java.util.List;

public record PSPTransactionReportResponse(
        String status,
        List<TransactionReportData> response) {
}


