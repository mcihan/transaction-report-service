package com.cihan.transactionreportservice.controller.dto;

import com.cihan.transactionreportservice.domain.dto.TransactionReportData;

import java.util.List;

public record TransactionReportResponse(
        String status,
        List<TransactionReportData> response) {

}
