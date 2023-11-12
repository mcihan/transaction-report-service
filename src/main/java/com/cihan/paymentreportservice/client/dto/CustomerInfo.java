package com.cihan.paymentreportservice.client.dto;

public record CustomerInfo(String billingFirstName, String billingLastName, String email, String billingCompany,
                           String billingCity, String updated_at, String created_at, int id, String billingAddress1) {
}


//        "updated_at": "2023-02-03 13:28:37",
//        "created_at": "2023-02-03 13:28:37",