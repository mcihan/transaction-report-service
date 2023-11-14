package com.cihan.transactionreportservice.controller;

import com.cihan.transactionreportservice.controller.response.CustomerDetailResponse;
import com.cihan.transactionreportservice.service.CustomerService;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<CustomerDetailResponse> getCustomerDetail(@RequestParam("transactionId")
                                                                    @Valid
                                                                    @NotBlank
                                                                    @Max(32)
                                                                    @Schema(type = "string", example = "981862-1499180435-111")
                                                                    String transactionId) {
        CustomerDetailResponse customerDetail = customerService.getCustomerDetail(transactionId);
        return ResponseEntity.ok(customerDetail);
    }
}
