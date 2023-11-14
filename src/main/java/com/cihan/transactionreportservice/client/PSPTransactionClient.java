package com.cihan.transactionreportservice.client;

import com.cihan.transactionreportservice.client.response.*;
import com.cihan.transactionreportservice.client.request.PSPCustomerRequest;
import com.cihan.transactionreportservice.client.request.PSPTransactionListRequest;
import com.cihan.transactionreportservice.client.request.PSPTransactionReportRequest;
import com.cihan.transactionreportservice.client.request.PSPTransactionRequest;
import com.cihan.transactionreportservice.config.PSPClientConfig;
import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PSPClient", url = "${psp-client.url}", configuration = PSPClientConfig.class)
public interface PSPTransactionClient {

    @PostMapping(value = "/client", consumes = MediaType.APPLICATION_JSON_VALUE)
    PSPCustomerResponse getCustomer(@RequestBody PSPCustomerRequest pspCustomerRequest);

    @PostMapping(value = "/transaction", consumes = MediaType.APPLICATION_JSON_VALUE)
    PSPTransactionResponse getTransaction(@RequestBody PSPTransactionRequest transactionRequest);

    @PostMapping(value = "/transactions/report", consumes = MediaType.APPLICATION_JSON_VALUE)
    PSPTransactionReportResponse getTransactionReport(@QueryMap PSPTransactionReportRequest transactionReportRequest);

    @PostMapping(value = "/transaction/list", consumes = MediaType.APPLICATION_JSON_VALUE)
    PSPTransactionListResponse getTransactionByQuery(@QueryMap PSPTransactionListRequest request);

}
