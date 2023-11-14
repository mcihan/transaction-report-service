package com.cihan.transactionreportservice.service.impl;

import com.cihan.transactionreportservice.client.PSPTransactionClient;
import com.cihan.transactionreportservice.client.request.PSPCustomerRequest;
import com.cihan.transactionreportservice.client.response.PSPCustomerResponse;
import com.cihan.transactionreportservice.controller.response.CustomerDetailResponse;
import com.cihan.transactionreportservice.mapper.DtoMapper;
import com.cihan.transactionreportservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final PSPTransactionClient pspTransactionClient;
    private final DtoMapper dtoMapper;

    public CustomerDetailResponse getCustomerDetail(final String transactionId) {
        PSPCustomerResponse pspCustomerDetail = pspTransactionClient.getCustomer(new PSPCustomerRequest(transactionId));
        return dtoMapper.toCustomerDetailResponse(pspCustomerDetail);
    }
}