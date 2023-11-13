package com.cihan.paymentreportservice.domain.dto;


public record Ipn(Boolean sent, IpnMerchant merchant) {
}
