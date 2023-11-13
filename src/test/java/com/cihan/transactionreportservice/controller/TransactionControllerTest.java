package com.cihan.transactionreportservice.controller;


import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class TransactionControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @SneakyThrows
    void getTransactionTest() {
        String transactionId = "981862-1499180435-111";
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/transaction")
                        .param("transactionId", transactionId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fx").isNotEmpty())
                .andExpect(jsonPath("$.customerInfo").isNotEmpty())
                .andExpect(jsonPath("$.merchant").isNotEmpty())
                .andExpect(jsonPath("$.transaction.merchant.status").value("APPROVED"));
    }

    @Test
    @SneakyThrows
    void getTransactionReportTest() {
        String fromDate = "2015-01-01";
        String toDate = "2023-11-01";
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/transaction/report")
                        .param("fromDate", fromDate)
                        .param("toDate", toDate)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("APPROVED"))
                .andExpect(jsonPath("$.response.size()").value(5))
                .andExpect(jsonPath("$.response[0].count").value(10));
    }

    @Test
    @SneakyThrows
    void getTransactionByQueryTest() {
        String fromDate = "2015-01-01";
        String toDate = "2023-11-01";
        String status = "APPROVED";
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/transaction/query")
                        .param("fromDate", fromDate)
                        .param("toDate", toDate)
                        .param("status", status)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.perPage").value(50))
                .andExpect(jsonPath("$.currentPage").value(1))
                .andExpect(jsonPath("$.from").value(1))
                .andExpect(jsonPath("$.to").value(31));
    }


}