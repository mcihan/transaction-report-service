package com.cihan.transactionreportservice.service;

import com.cihan.transactionreportservice.client.PSPTransactionClient;
import com.cihan.transactionreportservice.client.dto.PSPCustomerRequest;
import com.cihan.transactionreportservice.client.dto.PSPCustomerResponse;
import com.cihan.transactionreportservice.controller.dto.CustomerDetailResponse;
import com.cihan.transactionreportservice.mapper.DtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final PSPTransactionClient pspTransactionClient;
    private final DtoMapper dtoMapper;

    public CustomerDetailResponse getCustomerDetail(final String transactionId) {
        PSPCustomerResponse pspCustomerDetail = pspTransactionClient.getCustomer(new PSPCustomerRequest(transactionId));
        return dtoMapper.toCustomerDetailResponse(pspCustomerDetail);
    }
}