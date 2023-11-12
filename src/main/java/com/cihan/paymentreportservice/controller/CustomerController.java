package com.cihan.paymentreportservice.controller;

import com.cihan.paymentreportservice.controller.dto.CustomerDetailResponse;
import com.cihan.paymentreportservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping
    public ResponseEntity<CustomerDetailResponse> getCustomerDetail(@RequestHeader("Authorization") String token,
                                                                    @RequestParam("transactionId") String transactionId) {

        CustomerDetailResponse customerDetail = customerService.getCustomerDetail(token, transactionId);
        return ResponseEntity.ok(customerDetail);
    }
}
