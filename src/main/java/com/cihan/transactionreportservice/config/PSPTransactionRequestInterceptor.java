package com.cihan.transactionreportservice.config;

import com.cihan.transactionreportservice.domain.dto.LoginRequest;
import com.cihan.transactionreportservice.domain.dto.LoginResponse;
import com.cihan.transactionreportservice.service.AuthenticationService;
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