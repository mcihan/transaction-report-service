package com.cihan.transactionreportservice.service;

import com.cihan.transactionreportservice.client.request.PSPTransactionListRequest;
import com.cihan.transactionreportservice.client.request.PSPTransactionReportRequest;
import com.cihan.transactionreportservice.controller.response.TransactionQueryResponse;
import com.cihan.transactionreportservice.controller.response.TransactionReportResponse;
import com.cihan.transactionreportservice.controller.response.TransactionResponse;

public interface TransactionService {

    TransactionResponse getTransaction(String transactionId);

    TransactionReportResponse getTransactionReport(PSPTransactionReportRequest request);

    TransactionQueryResponse getTransactionsByQuery(PSPTransactionListRequest request);
}
