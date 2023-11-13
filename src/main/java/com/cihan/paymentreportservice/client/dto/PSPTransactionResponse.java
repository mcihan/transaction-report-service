package com.cihan.paymentreportservice.client.dto;

import com.cihan.paymentreportservice.domain.dto.CustomerInfo;
import com.cihan.paymentreportservice.domain.dto.Fx;
import com.cihan.paymentreportservice.domain.dto.Merchant;
import com.cihan.paymentreportservice.domain.dto.Transaction;

public record PSPTransactionResponse(Fx fx, Transaction transaction, CustomerInfo customerInfo, Merchant merchant) {
}
