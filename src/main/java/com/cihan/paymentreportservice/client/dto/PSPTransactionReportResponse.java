package com.cihan.paymentreportservice.client.dto;

import com.cihan.paymentreportservice.domain.dto.TransactionReportData;
import java.util.List;

public record PSPTransactionReportResponse(
        String status,
        List<TransactionReportData> response) {
}


