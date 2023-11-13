package com.cihan.transactionreportservice.service.impl;

import com.cihan.transactionreportservice.client.PSPTransactionClient;
import com.cihan.transactionreportservice.client.dto.*;
import com.cihan.transactionreportservice.controller.dto.TransactionListResponse;
import com.cihan.transactionreportservice.controller.dto.TransactionReportResponse;
import com.cihan.transactionreportservice.controller.dto.TransactionResponse;
import com.cihan.transactionreportservice.mapper.DtoMapper;
import com.cihan.transactionreportservice.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
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
