package com.cihan.paymentreportservice.config;

import com.cihan.paymentreportservice.domain.dto.LoginDto;
import com.cihan.paymentreportservice.service.LoginService;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientInterceptorConfig {

    @Value("${psp.credentials.email}")
    String email;


    @Value("${psp.credentials.password}")
    String password;


    @Bean
    public RequestInterceptor PSPTransactionRequestInterceptor(LoginService loginService) {
        return new PSPTransactionRequestInterceptor(loginService, new LoginDto(email, password));
    }

}