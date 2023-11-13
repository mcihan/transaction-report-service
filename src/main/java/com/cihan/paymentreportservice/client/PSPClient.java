package com.cihan.paymentreportservice.client;

import com.cihan.paymentreportservice.client.dto.*;
import feign.QueryMap;
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

    @PostMapping(value = "/transaction", consumes = MediaType.APPLICATION_JSON_VALUE)
    PSPTransactionResponse getTransaction(@RequestHeader("Authorization") String Authorization, @RequestBody PSPTransactionRequest transactionRequest);

    @PostMapping(value = "/transactions/report", consumes = MediaType.APPLICATION_JSON_VALUE)
    PSPTransactionReportResponse getTransactionReport(@RequestHeader("Authorization") String Authorization,  @QueryMap PSPTransactionReportRequest transactionReportRequest);

    @PostMapping(value = "/transaction/list", consumes = MediaType.APPLICATION_JSON_VALUE)
    PSPTransactionListResponse getTransactionByQuery(@RequestHeader("Authorization") String Authorization, @QueryMap PSPTransactionListRequest request);

}
