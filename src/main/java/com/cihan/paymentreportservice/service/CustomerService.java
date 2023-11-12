package com.cihan.paymentreportservice.service;

import com.cihan.paymentreportservice.client.PSPClient;
import com.cihan.paymentreportservice.client.dto.PSPCustomerRequest;
import com.cihan.paymentreportservice.client.dto.PSPCustomerResponse;
import com.cihan.paymentreportservice.controller.dto.CustomerDetailResponse;
import com.cihan.paymentreportservice.mapper.LoginMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final PSPClient pspClient;
    private final LoginMapper loginMapper;


    public CustomerDetailResponse getCustomerDetail(final String token, final String transactionId) {
        PSPCustomerResponse pspCustomerDetail = pspClient.getCustomer(token, new PSPCustomerRequest(transactionId));
        return loginMapper.toCustomerDetailResponse(pspCustomerDetail);
    }

    private HashMap<String, String> getHeader(String token) {
        return new HashMap<>() {{
            put("Authorization", token);
        }};
    }
}