package com.cihan.paymentreportservice.controller;

import com.cihan.paymentreportservice.client.dto.PSPLoginResponse;
import com.cihan.paymentreportservice.controller.dto.LoginRequest;
import com.cihan.paymentreportservice.controller.dto.LoginResponse;
import com.cihan.paymentreportservice.mapper.LoginMapper;
import com.cihan.paymentreportservice.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginMapper loginMapper;
    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse login = loginService.login(loginMapper.toLoginDto(loginRequest));
        return ResponseEntity.ok(login);
    }
}
