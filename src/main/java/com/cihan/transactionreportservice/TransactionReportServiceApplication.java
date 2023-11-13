package com.cihan.transactionreportservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
@EnableScheduling
public class TransactionReportServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionReportServiceApplication.class, args);
    }

}
