package com.cihan.transactionreportservice.service;

import com.cihan.transactionreportservice.domain.dto.LoginRequest;
import com.cihan.transactionreportservice.domain.dto.LoginResponse;

public interface AuthenticationService {

    LoginResponse authenticate(LoginRequest loginRequest);

    void refresh();

}