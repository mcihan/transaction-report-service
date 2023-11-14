package com.cihan.transactionreportservice.controller;

import com.cihan.transactionreportservice.controller.request.TransactionQueryRequest;
import com.cihan.transactionreportservice.controller.request.TransactionReportRequest;
import com.cihan.transactionreportservice.controller.response.TransactionQueryResponse;
import com.cihan.transactionreportservice.controller.response.TransactionReportResponse;
import com.cihan.transactionreportservice.controller.response.TransactionResponse;
import com.cihan.transactionreportservice.mapper.DtoMapper;
import com.cihan.transactionreportservice.service.TransactionService;
import feign.QueryMap;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
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
    public ResponseEntity<TransactionResponse> getTransaction(@RequestParam("transactionId")
                                                              @Valid
                                                              @NotBlank
                                                              @Max(32)
                                                              @Schema(type = "string", example = "981862-1499180435-111")
                                                              String transactionId) {

        TransactionResponse response = transactionService.getTransaction(transactionId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/report")
    public ResponseEntity<TransactionReportResponse> getTransactionReport(@QueryMap @Valid TransactionReportRequest request) {
        TransactionReportResponse response = transactionService.getTransactionReport(dtoMapper.toPSPRequest(request));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/query")
    public ResponseEntity<TransactionQueryResponse> getTransactionsByQuery(@QueryMap @Valid TransactionQueryRequest request) {
        TransactionQueryResponse response = transactionService.getTransactionsByQuery(dtoMapper.toPSPRequest(request));
        return ResponseEntity.ok(response);
    }


}
