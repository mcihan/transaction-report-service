package com.cihan.transactionreportservice.client;

import com.cihan.transactionreportservice.client.dto.*;
import com.cihan.transactionreportservice.domain.dto.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PSPTransactionClientTest {

    @Autowired
    private PSPTransactionClient pspTransactionClient;


    @Test
    void shouldGetCustomer() {
        String transactionId = "981862-1499180435-111";
        PSPCustomerResponse customer = pspTransactionClient.getCustomer(new PSPCustomerRequest(transactionId));
        assertNotNull(customer);
        assertNotNull(customer.customerInfo());
    }

    @Test
    void shouldGetTransaction() {
        String transactionId = "981862-1499180435-111";
        PSPTransactionResponse transaction = pspTransactionClient.getTransaction(new PSPTransactionRequest(transactionId));
        assertNotNull(transaction);
        assertNotNull(transaction.customerInfo());
    }

    @Test
    void shouldGetTransactionReport() {
        PSPTransactionReportRequest transactionReportRequest = new PSPTransactionReportRequest("2016-01-01", "2023-11-11", null, null);
        PSPTransactionReportResponse transactionReport = pspTransactionClient.getTransactionReport(transactionReportRequest);
        assertNotNull(transactionReport);
        assertNotNull(transactionReport.response());
        assertEquals(Status.APPROVED.name(), transactionReport.status());
    }
    @Test
    void shouldGetTransactionByQuery() {
        PSPTransactionListRequest request = PSPTransactionListRequest.builder()
                .fromDate("2016-01-01")
                .toDate("2023-11-11")
                .build();
        PSPTransactionListResponse response = pspTransactionClient.getTransactionByQuery(request);
        assertNotNull(response);
        assertNotNull(response.currentPage());
        assertNotNull(response.nextPageUrl());
    }

}