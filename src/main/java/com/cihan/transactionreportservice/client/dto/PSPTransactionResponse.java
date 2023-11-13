package com.cihan.transactionreportservice.client.dto;

import com.cihan.transactionreportservice.domain.dto.CustomerInfo;
import com.cihan.transactionreportservice.domain.dto.Fx;
import com.cihan.transactionreportservice.domain.dto.Merchant;
import com.cihan.transactionreportservice.domain.dto.Transaction;

public record PSPTransactionResponse(Fx fx, Transaction transaction, CustomerInfo customerInfo, Merchant merchant) {
}
