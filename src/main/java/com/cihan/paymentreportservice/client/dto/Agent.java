package com.cihan.paymentreportservice.client.dto;

public record Agent(
        Integer id,
        String customerIp,
        String customerUserAgent,
        String merchantIp,
        String merchantUserAgent,
        String created_at,
        String updated_at,
        Object deleted_at
) {
}
