package com.cihan.paymentreportservice.service;

import com.cihan.paymentreportservice.client.PSPTransactionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final PSPTransactionClient pspTransactionClient;
}
