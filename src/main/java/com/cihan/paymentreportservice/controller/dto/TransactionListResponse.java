package com.cihan.paymentreportservice.controller.dto;

import com.cihan.paymentreportservice.domain.dto.TransactionListData;

import java.util.List;

public record TransactionListResponse(
        Integer perPage,
        Integer currentPage,
        String nextPageUrl,
        Object prevPageUrl,
        Integer from,
        Integer to,
        List<TransactionListData> data) {
}