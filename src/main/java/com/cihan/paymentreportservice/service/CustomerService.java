package com.cihan.paymentreportservice.service;

import com.cihan.paymentreportservice.client.PSPTransactionClient;
import com.cihan.paymentreportservice.client.dto.PSPCustomerRequest;
import com.cihan.paymentreportservice.client.dto.PSPCustomerResponse;
import com.cihan.paymentreportservice.controller.dto.CustomerDetailResponse;
import com.cihan.paymentreportservice.mapper.DtoMapper;
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