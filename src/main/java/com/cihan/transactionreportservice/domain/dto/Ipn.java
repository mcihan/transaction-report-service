package com.cihan.transactionreportservice.domain.dto;


public record Ipn(Boolean sent, IpnMerchant merchant) {
}
