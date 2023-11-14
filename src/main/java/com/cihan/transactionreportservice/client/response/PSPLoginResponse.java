package com.cihan.transactionreportservice.client.response;

import com.cihan.transactionreportservice.domain.dto.Status;

public record PSPLoginResponse (String token, Status status){}
