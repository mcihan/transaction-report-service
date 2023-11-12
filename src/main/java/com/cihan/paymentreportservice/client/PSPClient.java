package com.cihan.paymentreportservice.client;

import com.cihan.paymentreportservice.client.dto.PSPCustomerRequest;
import com.cihan.paymentreportservice.client.dto.PSPCustomerResponse;
import com.cihan.paymentreportservice.client.dto.PSPLoginRequest;
import com.cihan.paymentreportservice.client.dto.PSPLoginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "PSPClient", url = "https://sandbox-reporting.rpdpymnt.com/api/v3")
public interface PSPClient {

    @PostMapping("/merchant/user/login")
    PSPLoginResponse login(@RequestBody PSPLoginRequest pSPLoginRequest);

    @PostMapping(value = "/client", consumes = MediaType.APPLICATION_JSON_VALUE)
    PSPCustomerResponse getCustomer(@RequestHeader("Authorization") String Authorization, @RequestBody PSPCustomerRequest pspCustomerRequest);


//
//    @PostMapping("/api/v3/client")
//    PSPCustomerResponse getCustomer(@RequestBody PSPCustomerRequest pspCustomerRequest);


}
