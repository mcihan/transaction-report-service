package com.cihan.paymentreportservice.client.dto;

import lombok.Builder;

@Builder
public record PSPLoginRequest (String email,String password){}