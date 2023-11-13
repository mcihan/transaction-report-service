package com.cihan.paymentreportservice.client;

import com.cihan.paymentreportservice.client.dto.PSPLoginRequest;
import com.cihan.paymentreportservice.client.dto.PSPLoginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PSPLoginClient", url = "${psp.url}")
public interface PSPLoginClient {

    @PostMapping("/merchant/user/login")
    PSPLoginResponse login(@RequestBody PSPLoginRequest pSPLoginRequest);

}
