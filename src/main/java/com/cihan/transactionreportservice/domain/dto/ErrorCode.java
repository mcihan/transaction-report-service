package com.cihan.transactionreportservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    DO_NOT_HONOR("Do not honor"),
    INVALID_TRANSACTION("Invalid Transaction"),
    INVALID_CARD("Invalid Card"),
    NOT_SUFFICIENT_FUNDS("Not sufficient funds"),
    INCORRECT_PIN("Incorrect PIN"),
    INVALID_COUNTRY_ASSOCIATION("Invalid country association"),
    CURRENCY_NOT_ALLOWED("Currency not allowed"),
    SECURE_TRANSPORT_ERROR("3-D Secure Transport Error"),
    TRANSACTION_NOT_PERMITTED("Transaction not permitted to cardholder");

    private final String value;

/*
    @JsonCreator
    public static ErrorCode fromString(String value) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.description.equalsIgnoreCase(value)) {
                return errorCode;
            }
        }
        throw new IllegalArgumentException("Unknown ErrorCode: " + value);
    }

    @JsonValue
    public String toString() {
        return description;
    }*/
}