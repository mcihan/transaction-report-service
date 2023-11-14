package com.cihan.transactionreportservice.service;

import com.cihan.transactionreportservice.client.PSPTransactionClient;
import com.cihan.transactionreportservice.client.response.*;
import com.cihan.transactionreportservice.client.request.PSPTransactionListRequest;
import com.cihan.transactionreportservice.client.request.PSPTransactionReportRequest;
import com.cihan.transactionreportservice.controller.response.TransactionQueryResponse;
import com.cihan.transactionreportservice.controller.response.TransactionReportResponse;
import com.cihan.transactionreportservice.controller.response.TransactionResponse;
import com.cihan.transactionreportservice.domain.dto.Merchant;
import com.cihan.transactionreportservice.domain.dto.Status;
import com.cihan.transactionreportservice.mapper.DtoMapperImpl;
import com.cihan.transactionreportservice.service.impl.TransactionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

// Execute without spring application context
class TransactionServiceTest {

    private PSPTransactionClient pspTransactionClient;

    private TransactionService transactionService;

    @BeforeEach
    void init() {
        pspTransactionClient = Mockito.mock(PSPTransactionClient.class);
        transactionService = new TransactionServiceImpl(pspTransactionClient, new DtoMapperImpl()); // run mvn clean install to generate it
    }

    @Test
    void shouldGetTransaction() {
        String merchant = "test-merchant";
        String transactionId = "trax-123";
        PSPTransactionResponse response = PSPTransactionResponse.builder()
                .merchant(new Merchant(merchant))
                .build();

        when(pspTransactionClient.getTransaction(Mockito.any())).thenReturn(response);

        TransactionResponse transaction = transactionService.getTransaction(transactionId);

        assertEquals(merchant, transaction.merchant().name());
    }

    @Test
    void shouldGetTransactionReport() {
        PSPTransactionReportRequest pspRequest = PSPTransactionReportRequest.builder()
                .fromDate("2016-01-01")
                .fromDate("2023-11-11")
                .build();

        PSPTransactionReportResponse pspResponse = PSPTransactionReportResponse.builder()
                .status(Status.APPROVED.name())
                .build();

        when(pspTransactionClient.getTransactionReport(pspRequest)).thenReturn(pspResponse);

        TransactionReportResponse transactionReport = transactionService.getTransactionReport(pspRequest);

        assertEquals(Status.APPROVED.name(), transactionReport.status());
    }

    @Test
    void shouldGetTransactionsByQuery() {

        String pageUrl = "bombabomba";
        PSPTransactionListRequest pspRequest = PSPTransactionListRequest.builder()
                .fromDate("2016-01-01")
                .fromDate("2023-11-11")
                .build();

        PSPTransactionListResponse pspResponse = PSPTransactionListResponse.builder()
                .nextPageUrl(pageUrl)
                .build();

        when(pspTransactionClient.getTransactionByQuery(pspRequest)).thenReturn(pspResponse);
        TransactionQueryResponse transactionsByQuery = transactionService.getTransactionsByQuery(pspRequest);

        assertEquals(pageUrl, transactionsByQuery.nextPageUrl());

    }
}