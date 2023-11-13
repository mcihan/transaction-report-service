package com.cihan.paymentreportservice.mapper;

import com.cihan.paymentreportservice.client.dto.*;
import com.cihan.paymentreportservice.controller.dto.*;
import com.cihan.paymentreportservice.domain.dto.LoginRequest;
import com.cihan.paymentreportservice.domain.dto.LoginResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DtoMapper {
    LoginRequest toLoginDto(com.cihan.paymentreportservice.controller.dto.LoginRequest loginRequest);
    LoginResponse toLoginDto(PSPLoginResponse pspLoginResponse);
    PSPLoginRequest toPSPLoginRequest(LoginRequest loginRequest);
    CustomerDetailResponse toCustomerDetailResponse(PSPCustomerResponse loginDto);

    PSPTransactionReportRequest toPSPRequest(TransactionReportRequest request);
    PSPTransactionListRequest toPSPRequest(TransactionListRequest request);
    TransactionListResponse toResponse(PSPTransactionListResponse response);
    TransactionReportResponse toResponse(PSPTransactionReportResponse response);
    TransactionResponse toResponse(PSPTransactionResponse response);


}
