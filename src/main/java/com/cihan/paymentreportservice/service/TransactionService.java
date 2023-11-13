package com.cihan.paymentreportservice.service;

import com.cihan.paymentreportservice.client.PSPTransactionClient;
import com.cihan.paymentreportservice.client.dto.*;
import com.cihan.paymentreportservice.controller.dto.TransactionListResponse;
import com.cihan.paymentreportservice.controller.dto.TransactionReportResponse;
import com.cihan.paymentreportservice.controller.dto.TransactionResponse;
import com.cihan.paymentreportservice.mapper.DtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final PSPTransactionClient pspTransactionClient;
    private final DtoMapper dtoMapper;

    public TransactionResponse getTransaction(String transactionId) {
        PSPTransactionResponse pspTransactionResponse = pspTransactionClient.getTransaction(new PSPTransactionRequest(transactionId));
        return dtoMapper.toResponse(pspTransactionResponse);
    }

    public TransactionReportResponse getTransactionReport(PSPTransactionReportRequest request) {
        PSPTransactionReportResponse pspTransactionReportResponse = pspTransactionClient.getTransactionReport(request);
        return dtoMapper.toResponse(pspTransactionReportResponse);
    }

    public TransactionListResponse getTransactionsByQuery(PSPTransactionListRequest request) {
        PSPTransactionListResponse pspTransactionListResponse = pspTransactionClient.getTransactionByQuery(request);
        return dtoMapper.toResponse(pspTransactionListResponse);
    }
}
