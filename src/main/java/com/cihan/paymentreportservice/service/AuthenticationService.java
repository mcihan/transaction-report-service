package com.cihan.paymentreportservice.service;

import com.cihan.paymentreportservice.client.PSPLoginClient;
import com.cihan.paymentreportservice.client.dto.PSPLoginRequest;
import com.cihan.paymentreportservice.client.dto.PSPLoginResponse;
import com.cihan.paymentreportservice.domain.dto.LoginResponse;
import com.cihan.paymentreportservice.domain.dto.LoginRequest;
import com.cihan.paymentreportservice.mapper.DtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    static final long TOKEN_CACHE_EXPIRE =  10 * 60  * 1000;  // token cached for 10 minutes
    private final PSPLoginClient pspClient;
    private final DtoMapper dtoMapper;

    @Cacheable("token")
    public LoginResponse authenticate(LoginRequest loginRequest) {
        PSPLoginRequest pspLoginRequest = dtoMapper.toPSPLoginRequest(loginRequest);
        PSPLoginResponse pspLoginResponse = pspClient.login(pspLoginRequest);
        return dtoMapper.toLoginDto(pspLoginResponse);
    }

    @Scheduled(fixedRate = TOKEN_CACHE_EXPIRE)
    @CacheEvict(value = "token", allEntries = true)
    public void refresh() {
        System.out.println("Token Cache Evicted!");
    }

}