package com.cihan.paymentreportservice.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PSPCustomerRequest {

    private String transactionId;
}
