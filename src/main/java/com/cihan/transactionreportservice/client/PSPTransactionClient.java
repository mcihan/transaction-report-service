package com.cihan.transactionreportservice.client;

import com.cihan.transactionreportservice.client.dto.*;
import com.cihan.transactionreportservice.config.PSPClientConfig;
import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PSPClient", url = "${psp.url}", configuration = PSPClientConfig.class)
public interface PSPTransactionClient {

    @PostMapping("/merchant/user/login")
    PSPLoginResponse login(@RequestBody PSPLoginRequest pSPLoginRequest);

    @PostMapping(value = "/client", consumes = MediaType.APPLICATION_JSON_VALUE)
    PSPCustomerResponse getCustomer(@RequestBody PSPCustomerRequest pspCustomerRequest);

    @PostMapping(value = "/transaction", consumes = MediaType.APPLICATION_JSON_VALUE)
    PSPTransactionResponse getTransaction(@RequestBody PSPTransactionRequest transactionRequest);

    @PostMapping(value = "/transactions/report", consumes = MediaType.APPLICATION_JSON_VALUE)
    PSPTransactionReportResponse getTransactionReport(@QueryMap PSPTransactionReportRequest transactionReportRequest);

    @PostMapping(value = "/transaction/list", consumes = MediaType.APPLICATION_JSON_VALUE)
    PSPTransactionListResponse getTransactionByQuery(@QueryMap PSPTransactionListRequest request);

}
