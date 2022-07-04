package com.acoustic.integrationtestcontroller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class MonthlyGrossControllerTest {

    public static final String MONTHLY_GROSS_DESCRIPTION = "Monthly gross";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private final String MONTHLY_GROSS_ENDPOINT = "/monthlyGross/getMonthlyGross/";


    @ParameterizedTest
    @CsvSource({"6000, 6000.00", "7000, 7000.00", "8555,8555.00", "15143.99,15143.99"})
    public void calculateDisabilityZus(BigDecimal input, BigDecimal annualGross) throws Exception {
        var expected = this.objectMapper.writeValueAsString(Map.of(MONTHLY_GROSS_DESCRIPTION, annualGross));
        this.mockMvc.perform(post(MONTHLY_GROSS_ENDPOINT + input).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

}