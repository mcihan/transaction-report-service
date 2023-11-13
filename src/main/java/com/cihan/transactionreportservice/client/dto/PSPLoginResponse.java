package com.cihan.transactionreportservice.client.dto;

import com.cihan.transactionreportservice.domain.dto.Status;

public record PSPLoginResponse (String token, Status status){}
