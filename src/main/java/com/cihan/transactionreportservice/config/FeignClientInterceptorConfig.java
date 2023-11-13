package com.cihan.transactionreportservice.config;

import com.cihan.transactionreportservice.domain.dto.LoginRequest;
import com.cihan.transactionreportservice.service.AuthenticationService;
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
    public RequestInterceptor PSPTransactionRequestInterceptor(AuthenticationService authenticationService) {
        return new PSPTransactionRequestInterceptor(authenticationService, new LoginRequest(email, password));
    }

}