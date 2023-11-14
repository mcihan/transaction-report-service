package com.cihan.transactionreportservice.config;

import com.cihan.transactionreportservice.domain.dto.LoginRequest;
import com.cihan.transactionreportservice.service.AuthenticationService;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PSPClientConfig {

    @Value("${psp-client.credentials.email}")
    String email;


    @Value("${psp-client.credentials.password}")
    String password;


    @Bean
    public RequestInterceptor PSPTransactionRequestInterceptor(AuthenticationService authenticationService) {
        return new PSPClientRequestInterceptor(authenticationService, new LoginRequest(email, password));
    }

}