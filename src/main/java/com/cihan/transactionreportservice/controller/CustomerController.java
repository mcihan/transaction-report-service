package com.cihan.transactionreportservice.controller;

import com.cihan.transactionreportservice.controller.dto.CustomerDetailResponse;
import com.cihan.transactionreportservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<CustomerDetailResponse> getCustomerDetail(@RequestParam("transactionId") String transactionId) {
        CustomerDetailResponse customerDetail = customerService.getCustomerDetail(transactionId);
        return ResponseEntity.ok(customerDetail);
    }
}
