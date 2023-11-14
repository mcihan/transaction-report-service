package com.cihan.transactionreportservice.client.request;

import lombok.Builder;

@Builder
public record PSPLoginRequest (String email,String password){}