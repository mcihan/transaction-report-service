package com.cihan.transactionreportservice.domain.dto;

public record IpnMerchant(
        String transactionId,
        String referenceNo,
        Integer amount,
        String currency,
        Integer date,
        String code,
        String message,
        String operation,
        String type,
        Status status,
        Object customData,
        String chainId,
        String paymentType,
        String token,
        Integer convertedAmount,
        String convertedCurrency,
        String iPNUrl,
        String ipnType,
        String authTransactionId
) {
}