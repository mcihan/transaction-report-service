package com.cihan.paymentreportservice.controller;

import com.cihan.paymentreportservice.client.PSPTransactionClient;
import com.cihan.paymentreportservice.client.dto.*;
import feign.QueryMap;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final PSPTransactionClient pspTransactionClient;

    @GetMapping
    public ResponseEntity<PSPTransactionResponse> getTransaction( @RequestParam("transactionId") String transactionId) {
        PSPTransactionResponse transactionResponse = pspTransactionClient.getTransaction(new PSPTransactionRequest(transactionId));
        return ResponseEntity.ok(transactionResponse);
    }

    @GetMapping("/report")
    public ResponseEntity<PSPTransactionReportResponse> getTransactionReport( @QueryMap PSPTransactionReportRequest request) {
        PSPTransactionReportResponse transactionReport = pspTransactionClient.getTransactionReport(request);
        return ResponseEntity.ok(transactionReport);
    }

    @GetMapping("/query")
    public ResponseEntity<PSPTransactionListResponse> getTransactionsByQuery(@QueryMap PSPTransactionListRequest request) {
        PSPTransactionListResponse transactionReport = pspTransactionClient.getTransactionByQuery(request);
        return ResponseEntity.ok(transactionReport);
    }


}
