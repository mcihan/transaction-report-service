package com.cihan.transactionreportservice.controller.dto;

import com.cihan.transactionreportservice.domain.dto.TransactionListData;

import java.util.List;

public record TransactionListResponse(
        Integer perPage,
        Integer currentPage,
        String nextPageUrl,
        String prevPageUrl,
        Integer from,
        Integer to,
        List<TransactionListData> data) {
}