package com.cihan.transactionreportservice.service.impl;

import com.cihan.transactionreportservice.client.PSPLoginClient;
import com.cihan.transactionreportservice.client.request.PSPLoginRequest;
import com.cihan.transactionreportservice.client.response.PSPLoginResponse;
import com.cihan.transactionreportservice.domain.dto.LoginRequest;
import com.cihan.transactionreportservice.domain.dto.LoginResponse;
import com.cihan.transactionreportservice.mapper.DtoMapper;
import com.cihan.transactionreportservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PSPLoginClient pspClient;
    private final DtoMapper dtoMapper;

    @Cacheable("token")
    public LoginResponse authenticate(LoginRequest loginRequest) {
        PSPLoginRequest pspLoginRequest = dtoMapper.toPSPLoginRequest(loginRequest);
        PSPLoginResponse pspLoginResponse = pspClient.login(pspLoginRequest);
        return dtoMapper.toLoginDto(pspLoginResponse);
    }

    @Scheduled(fixedRateString ="${psp-client.authentication-token-expire-time}")
    @CacheEvict(value = "token", allEntries = true)
    public void refresh() {
        log.info("Token Cache Evicted!");
    }

}