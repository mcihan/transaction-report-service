package com.cihan.transactionreportservice.client.response;

import com.cihan.transactionreportservice.domain.dto.TransactionListData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PSPTransactionListResponse(
        @JsonProperty("per_page")
        Integer perPage,
        @JsonProperty("current_page")
        Integer currentPage,
        @JsonProperty("first_page_url")
        String firstPageUrl,
        @JsonProperty("next_page_url")
        String nextPageUrl,
        @JsonProperty("prev_page_url")
        String prevPageUrl,
        Integer from,
        Integer to,
        List<TransactionListData> data) {
}


