package com.cihan.transactionreportservice.mapper;

import com.cihan.transactionreportservice.client.dto.*;
import com.cihan.transactionreportservice.controller.dto.*;
import com.cihan.transactionreportservice.domain.dto.LoginRequest;
import com.cihan.transactionreportservice.domain.dto.LoginResponse;
import com.cihan.transactionreportservice.domain.dto.PaymentMethod;
import com.cihan.transactionreportservice.domain.dto.Status;
import org.mapstruct.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface DtoMapper {
    LoginResponse toLoginDto(PSPLoginResponse pspLoginResponse);
    PSPLoginRequest toPSPLoginRequest(LoginRequest loginRequest);
    CustomerDetailResponse toCustomerDetailResponse(PSPCustomerResponse loginDto);

    @Mapping(source = "toDate", target = "toDate", qualifiedByName = "getFormattedDate")
    @Mapping(source = "fromDate", target = "fromDate", qualifiedByName = "getFormattedDate")
    PSPTransactionReportRequest toPSPRequest(TransactionReportRequest request);

    @Mapping(source = "toDate", target = "toDate", qualifiedByName = "getFormattedDate")
    @Mapping(source = "fromDate", target = "fromDate", qualifiedByName = "getFormattedDate")
    @Mapping(source = "paymentMethod", target = "paymentMethod", qualifiedByName = "getPaymentMethod", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Mapping(source = "status", target = "status", qualifiedByName = "getStatus", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    PSPTransactionListRequest toPSPRequest(TransactionListRequest request);
    TransactionListResponse toResponse(PSPTransactionListResponse response);
    TransactionReportResponse toResponse(PSPTransactionReportResponse response);
    TransactionResponse toResponse(PSPTransactionResponse response);


    @Named("getFormattedDate")
    default String getFormattedDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    @Named("getPaymentMethod")
    default String getPaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethod.name();
    }
    @Named("getStatus")
    default String getStatus(Status status) {
        return status.name();
    }



}
