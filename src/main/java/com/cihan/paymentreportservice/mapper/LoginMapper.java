package com.cihan.paymentreportservice.mapper;

import com.cihan.paymentreportservice.client.dto.PSPCustomerResponse;
import com.cihan.paymentreportservice.client.dto.PSPLoginRequest;
import com.cihan.paymentreportservice.client.dto.PSPLoginResponse;
import com.cihan.paymentreportservice.controller.dto.CustomerDetailResponse;
import com.cihan.paymentreportservice.controller.dto.LoginRequest;
import com.cihan.paymentreportservice.controller.dto.LoginResponse;
import com.cihan.paymentreportservice.domain.dto.LoginDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoginMapper {
    LoginDto toLoginDto(LoginRequest loginRequest);
    LoginResponse toLoginDto(PSPLoginResponse pspLoginResponse);
    PSPLoginRequest toPSPLoginRequest(LoginDto loginDto);
    CustomerDetailResponse toCustomerDetailResponse(PSPCustomerResponse loginDto);

}
