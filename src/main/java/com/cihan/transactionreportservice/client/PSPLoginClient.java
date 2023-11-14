package com.cihan.transactionreportservice.client;

import com.cihan.transactionreportservice.client.request.PSPLoginRequest;
import com.cihan.transactionreportservice.client.response.PSPLoginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PSPLoginClient", url = "${psp-client.url}")
public interface PSPLoginClient {

    @PostMapping("/merchant/user/login")
    PSPLoginResponse login(@RequestBody PSPLoginRequest pSPLoginRequest);

}
