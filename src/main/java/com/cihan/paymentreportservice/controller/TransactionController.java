package com.cihan.paymentreportservice.controller;

import com.cihan.paymentreportservice.controller.dto.*;
import com.cihan.paymentreportservice.mapper.DtoMapper;
import com.cihan.paymentreportservice.service.TransactionService;
import feign.QueryMap;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final DtoMapper dtoMapper;

    @GetMapping
    public ResponseEntity<TransactionResponse> getTransaction(@RequestParam("transactionId") String transactionId) {
        TransactionResponse response = transactionService.getTransaction(transactionId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/report")
    public ResponseEntity<TransactionReportResponse> getTransactionReport(@QueryMap TransactionReportRequest request) {
        TransactionReportResponse response = transactionService.getTransactionReport(dtoMapper.toPSPRequest(request));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/query")
    public ResponseEntity<TransactionListResponse> getTransactionsByQuery(@QueryMap TransactionListRequest request) {
        TransactionListResponse response = transactionService.getTransactionsByQuery(dtoMapper.toPSPRequest(request));
        return ResponseEntity.ok(response);
    }


}
