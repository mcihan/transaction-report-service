package com.cihan.paymentreportservice.service;

import com.cihan.paymentreportservice.client.PSPClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final PSPClient pspClient;
}
