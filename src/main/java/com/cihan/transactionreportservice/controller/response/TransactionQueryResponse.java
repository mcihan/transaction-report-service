package com.cihan.transactionreportservice.controller.response;

import com.cihan.transactionreportservice.domain.dto.TransactionListData;

import java.util.List;

public record TransactionQueryResponse(
        Integer perPage,
        Integer currentPage,
        String firstPageUrl,
        String nextPageUrl,
        String prevPageUrl,
        Integer from,
        Integer to,
        List<TransactionListData> data) {
}