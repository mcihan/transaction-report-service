package com.cihan.transactionreportservice.client;

import com.cihan.transactionreportservice.client.request.PSPLoginRequest;
import com.cihan.transactionreportservice.client.response.PSPLoginResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PSPLoginClientTest {

    @Autowired
    private PSPLoginClient loginClientTest;


    @Value("${psp-client.credentials.email}")
    private String email;

    @Value("${psp-client.credentials.password}")
    private String password;


    @Test
    void shouldLogin() {
        PSPLoginRequest request = new PSPLoginRequest(email, password);
        PSPLoginResponse login = loginClientTest.login(request);
        assertNotNull(login);
        assertNotNull(login.token());
    }

}