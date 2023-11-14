package com.cihan.transactionreportservice.service;

import com.cihan.transactionreportservice.controller.response.CustomerDetailResponse;

public interface CustomerService {
    CustomerDetailResponse getCustomerDetail(final String transactionId);
}