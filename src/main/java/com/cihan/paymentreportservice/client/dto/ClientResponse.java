package com.cihan.paymentreportservice.client.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "customerInfo"
})
public class ClientResponse {
    @JsonProperty("customerInfo")
    private CustomerInfo customerInfo;
}