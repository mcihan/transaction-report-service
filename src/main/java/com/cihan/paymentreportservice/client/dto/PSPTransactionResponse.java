package com.cihan.paymentreportservice.client.dto;

public record PSPTransactionResponse(Fx fx, Transaction transaction, CustomerInfo customerInfo, Merchant merchant) {
}
