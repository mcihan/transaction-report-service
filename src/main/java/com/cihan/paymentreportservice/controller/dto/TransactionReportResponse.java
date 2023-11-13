package com.cihan.paymentreportservice.controller.dto;

import com.cihan.paymentreportservice.domain.dto.TransactionReportData;

import java.util.List;

public record TransactionReportResponse(
        String status,
        List<TransactionReportData> response) {
}
