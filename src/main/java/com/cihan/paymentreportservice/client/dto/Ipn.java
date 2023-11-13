package com.cihan.paymentreportservice.client.dto;


public record Ipn(Boolean sent, IpnMerchant merchant) {
}
