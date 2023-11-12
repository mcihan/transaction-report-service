package com.cihan.paymentreportservice.client.dto;



import java.util.List;


public record PSPTransactionReportResponse(
        String status,
        List<TransactionReportData> response) {

}


