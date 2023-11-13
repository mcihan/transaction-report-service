package com.cihan.transactionreportservice.mapper;

import com.cihan.transactionreportservice.client.dto.*;
import com.cihan.transactionreportservice.controller.dto.*;
import com.cihan.transactionreportservice.domain.dto.LoginRequest;
import com.cihan.transactionreportservice.domain.dto.LoginResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface DtoMapper {
    LoginRequest toLoginDto(com.cihan.transactionreportservice.controller.dto.LoginRequest loginRequest);
    LoginResponse toLoginDto(PSPLoginResponse pspLoginResponse);
    PSPLoginRequest toPSPLoginRequest(LoginRequest loginRequest);
    CustomerDetailResponse toCustomerDetailResponse(PSPCustomerResponse loginDto);

    @Mapping(source = "toDate", target = "toDate", qualifiedByName = "getFormattedDate")
    @Mapping(source = "fromDate", target = "fromDate", qualifiedByName = "getFormattedDate")
    PSPTransactionReportRequest toPSPRequest(TransactionReportRequest request);
    PSPTransactionListRequest toPSPRequest(TransactionListRequest request);
    TransactionListResponse toResponse(PSPTransactionListResponse response);
    TransactionReportResponse toResponse(PSPTransactionReportResponse response);
    TransactionResponse toResponse(PSPTransactionResponse response);


    @Named("getFormattedDate")
    default String getFormattedDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }



}
