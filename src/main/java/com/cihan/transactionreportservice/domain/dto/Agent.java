package com.cihan.transactionreportservice.domain.dto;

public record Agent(
        Integer id,
        String customerIp,
        String customerUserAgent,
        String merchantIp,
        String merchantUserAgent,
        String created_at,
        String updated_at,
        String deleted_at
) {
}
