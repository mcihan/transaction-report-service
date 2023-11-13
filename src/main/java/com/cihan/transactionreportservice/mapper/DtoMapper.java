package com.cihan.transactionreportservice.mapper;

import com.cihan.transactionreportservice.client.dto.*;
import com.cihan.transactionreportservice.controller.dto.*;
import com.cihan.transactionreportservice.domain.dto.LoginRequest;
import com.cihan.transactionreportservice.domain.dto.LoginResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DtoMapper {
    LoginRequest toLoginDto(com.cihan.transactionreportservice.controller.dto.LoginRequest loginRequest);
    LoginResponse toLoginDto(PSPLoginResponse pspLoginResponse);
    PSPLoginRequest toPSPLoginRequest(LoginRequest loginRequest);
    CustomerDetailResponse toCustomerDetailResponse(PSPCustomerResponse loginDto);

    PSPTransactionReportRequest toPSPRequest(TransactionReportRequest request);
    PSPTransactionListRequest toPSPRequest(TransactionListRequest request);
    TransactionListResponse toResponse(PSPTransactionListResponse response);
    TransactionReportResponse toResponse(PSPTransactionReportResponse response);
    TransactionResponse toResponse(PSPTransactionResponse response);


}
