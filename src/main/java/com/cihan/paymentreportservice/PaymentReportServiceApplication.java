package com.cihan.paymentreportservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PaymentReportServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentReportServiceApplication.class, args);
    }

}
