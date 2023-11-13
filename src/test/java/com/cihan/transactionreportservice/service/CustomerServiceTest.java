package com.cihan.transactionreportservice.service;

import com.cihan.transactionreportservice.client.PSPTransactionClient;
import com.cihan.transactionreportservice.client.dto.PSPCustomerResponse;
import com.cihan.transactionreportservice.controller.dto.CustomerDetailResponse;
import com.cihan.transactionreportservice.domain.dto.CustomerInfo;
import com.cihan.transactionreportservice.mapper.DtoMapper;
import com.cihan.transactionreportservice.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerServiceTest {

    @Mock
    private PSPTransactionClient pspTransactionClient;
    @Autowired
    private DtoMapper dtoMapper;

    private CustomerService customerService;

    @BeforeEach
    void init() {
        customerService = new CustomerServiceImpl(pspTransactionClient, dtoMapper);
    }

    @Test
    void shouldGetCustomerDetail() {
        String transactionID = "1234";
        String billingCity = "billingCity";

        CustomerInfo customerInfo = CustomerInfo.builder()
                .billingCity(billingCity)
                .build();

        PSPCustomerResponse pspCustomerResponse = new PSPCustomerResponse(customerInfo);
        when(pspTransactionClient.getCustomer(Mockito.any())).thenReturn(pspCustomerResponse);

        CustomerDetailResponse customerDetail = customerService.getCustomerDetail(transactionID);

        assertEquals(billingCity, customerDetail.customerInfo().billingCity());
    }


}