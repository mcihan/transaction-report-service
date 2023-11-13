package com.cihan.paymentreportservice.config;

import com.cihan.paymentreportservice.controller.dto.LoginResponse;
import com.cihan.paymentreportservice.domain.dto.LoginDto;
import com.cihan.paymentreportservice.service.LoginService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PSPTransactionRequestInterceptor implements RequestInterceptor {
	
    private final LoginService loginService;
    private final LoginDto loginDto;

    @Override
    public void apply(RequestTemplate template) {
        LoginResponse loginData = loginService.login(loginDto);
        template.header("Authorization", loginData.token());
    }
}