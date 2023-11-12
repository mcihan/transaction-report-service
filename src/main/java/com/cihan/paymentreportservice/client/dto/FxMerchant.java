package com.cihan.paymentreportservice.client.dto;

import java.math.BigInteger;

public record FxMerchant(BigInteger originalAmount, String originalCurrency) {
}
