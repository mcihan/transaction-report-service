package com.cihan.transactionreportservice.controller.response;

import com.cihan.transactionreportservice.domain.dto.CustomerInfo;
import com.cihan.transactionreportservice.domain.dto.Fx;
import com.cihan.transactionreportservice.domain.dto.Merchant;
import com.cihan.transactionreportservice.domain.dto.Transaction;

public record TransactionResponse(Fx fx, Transaction transaction, CustomerInfo customerInfo, Merchant merchant) {
}
