package com.cihan.paymentreportservice.controller.dto;

import com.cihan.paymentreportservice.domain.dto.Status;

public record LoginResponse(String token, Status status){}