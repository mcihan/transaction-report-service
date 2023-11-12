package com.cihan.paymentreportservice.service;

import com.cihan.paymentreportservice.client.PSPClient;
import com.cihan.paymentreportservice.client.dto.PSPLoginRequest;
import com.cihan.paymentreportservice.client.dto.PSPLoginResponse;
import com.cihan.paymentreportservice.controller.dto.LoginResponse;
import com.cihan.paymentreportservice.domain.dto.LoginDto;
import com.cihan.paymentreportservice.mapper.LoginMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final PSPClient pspClient;
    private final LoginMapper loginMapper;

    public LoginResponse login(LoginDto loginDto) {
        PSPLoginRequest pspLoginRequest = loginMapper.toPSPLoginRequest(loginDto);
        PSPLoginResponse pspLoginResponse = pspClient.login(pspLoginRequest);
        return loginMapper.toLoginDto(pspLoginResponse);
    }

}