package com.cihan.paymentreportservice.client.dto;

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
        String status,
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