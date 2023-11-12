package com.cihan.paymentreportservice.controller;

import com.cihan.paymentreportservice.client.PSPClient;
import com.cihan.paymentreportservice.client.dto.PSPTransactionReportRequest;
import com.cihan.paymentreportservice.client.dto.PSPTransactionReportResponse;
import com.cihan.paymentreportservice.client.dto.PSPTransactionRequest;
import com.cihan.paymentreportservice.client.dto.PSPTransactionResponse;
import feign.QueryMap;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final PSPClient pspClient;

    @GetMapping
    public ResponseEntity<PSPTransactionResponse> getTransaction(@RequestHeader("Authorization") String authorization,
                                                                 @RequestParam("transactionId") String transactionId) {
        PSPTransactionResponse transactionResponse = pspClient.getTransaction(authorization, new PSPTransactionRequest(transactionId));
        return ResponseEntity.ok(transactionResponse);
    }

    @GetMapping("/report")
    public ResponseEntity<PSPTransactionReportResponse> getTransactionReport(@RequestHeader("Authorization") String authorization, @QueryMap PSPTransactionReportRequest request) {
        PSPTransactionReportResponse transactionReport = pspClient.getTransactionReport(authorization, request);
        return ResponseEntity.ok(transactionReport);
    }

}
