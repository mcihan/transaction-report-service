package com.cihan.transactionreportservice.service;

import com.cihan.transactionreportservice.client.dto.PSPTransactionListRequest;
import com.cihan.transactionreportservice.client.dto.PSPTransactionReportRequest;
import com.cihan.transactionreportservice.controller.dto.TransactionListResponse;
import com.cihan.transactionreportservice.controller.dto.TransactionReportResponse;
import com.cihan.transactionreportservice.controller.dto.TransactionResponse;

public interface TransactionService {

    TransactionResponse getTransaction(String transactionId);

    TransactionReportResponse getTransactionReport(PSPTransactionReportRequest request);

    TransactionListResponse getTransactionsByQuery(PSPTransactionListRequest request);
}
