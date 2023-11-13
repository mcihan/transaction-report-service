package com.cihan.paymentreportservice.config;

import com.cihan.paymentreportservice.controller.dto.LoginResponse;
import com.cihan.paymentreportservice.domain.dto.LoginDto;
import com.cihan.paymentreportservice.service.LoginService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthRequestInterceptor implements RequestInterceptor {
	
    private final LoginService loginService;

    @Override
    public void apply(RequestTemplate template) {
        LoginResponse loginData = loginService.login(new LoginDto("demo@financialhouse.io", "cjaiU8CV"));
        template.header("Authorization", loginData.token());
    }
}