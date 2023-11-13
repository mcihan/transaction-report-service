package com.cihan.paymentreportservice.client.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PSPTransactionListResponse(
        @JsonProperty("per_page")
        Integer perPage,
        @JsonProperty("current_page")
        Integer currentPage,
        @JsonProperty("next_page_url")
        String nextPageUrl,
        @JsonProperty("prev_page_url")
        Object prevPageUrl,
        Integer from,
        Integer to,
        List<TransactionListData> data) {
}


