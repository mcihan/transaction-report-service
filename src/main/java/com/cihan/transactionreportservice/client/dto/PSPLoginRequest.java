package com.cihan.transactionreportservice.client.dto;

import lombok.Builder;

@Builder
public record PSPLoginRequest (String email,String password){}