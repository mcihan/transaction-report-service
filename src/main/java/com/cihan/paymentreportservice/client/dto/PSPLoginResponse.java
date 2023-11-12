package com.cihan.paymentreportservice.client.dto;

import com.cihan.paymentreportservice.domain.dto.Status;

public record PSPLoginResponse (String token, Status status){}
