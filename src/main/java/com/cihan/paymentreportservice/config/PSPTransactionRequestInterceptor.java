package com.cihan.paymentreportservice.config;

import com.cihan.paymentreportservice.domain.dto.LoginRequest;
import com.cihan.paymentreportservice.domain.dto.LoginResponse;
import com.cihan.paymentreportservice.service.AuthenticationService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PSPTransactionRequestInterceptor implements RequestInterceptor {
	
    private final AuthenticationService authenticationService;
    private final LoginRequest loginRequest;

    @Override
    public void apply(RequestTemplate template) {
        LoginResponse loginData = authenticationService.authenticate(loginRequest);
        template.header("Authorization", loginData.token());
    }
}