package com.cihan.transactionreportservice.domain.dto;

import java.math.BigInteger;

public record FxMerchant(BigInteger originalAmount, String originalCurrency) {
}
