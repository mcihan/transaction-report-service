package com.cihan.transactionreportservice.service;

import com.cihan.transactionreportservice.domain.dto.LoginRequest;
import com.cihan.transactionreportservice.domain.dto.LoginResponse;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthenticationServiceTest {

    @Autowired
    private AuthenticationService authenticationService;


    @Value("${psp-client.credentials.email}")
    private String email;

    @Value("${psp-client.credentials.password}")
    private String password;


    @Test
    void shouldLogin() {
        LoginRequest request = new LoginRequest(email, password);
        LoginResponse login = authenticationService.authenticate(request);
        assertNotNull(login);
        assertNotNull(login.token());
    }

    @Test
    @SneakyThrows
    void tokenCacheTest() {
        LoginRequest request = new LoginRequest(email, password);

        LoginResponse firstLogin = authenticationService.authenticate(request);
        Thread.sleep(2000l);
        LoginResponse secondLogin = authenticationService.authenticate(request);

        assertEquals(firstLogin.token(), secondLogin.token());
        assertSame(firstLogin, secondLogin);
    }
}