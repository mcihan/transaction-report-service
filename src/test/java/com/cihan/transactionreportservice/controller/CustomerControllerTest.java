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
class CustomerControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @SneakyThrows
    void getCustomerTest() {
        String transactionId = "981862-1499180435-111";
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customer")
                        .param("transactionId", transactionId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerInfo").isNotEmpty())
                .andExpect(jsonPath("$.customerInfo.billingFirstName").value("John"))
                .andExpect(jsonPath("$.customerInfo.billingLastName").value("O'Connor"))
                .andExpect(jsonPath("$.customerInfo.email").value("oconnor@bumin.com.tr"));
    }
}
