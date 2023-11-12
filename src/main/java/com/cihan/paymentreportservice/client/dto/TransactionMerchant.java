package com.cihan.paymentreportservice.client.dto;

public record TransactionMerchant(
        String referenceNo,
        int merchantId,
        String status,
        String channel,
        Object customData,
        String chainId,
        String type,
        int agentInfoId,
        String operation,
        String updated_at,
        String created_at,
        int id,
        int fxTransactionId,
        int acquirerTransactionId,
        int code,
        String message,
        String transactionId,
        Agent agent
) {

}