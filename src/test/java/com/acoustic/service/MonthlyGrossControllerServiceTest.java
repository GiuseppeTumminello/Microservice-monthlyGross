package com.acoustic.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(MockitoExtension.class)
class MonthlyGrossControllerServiceTest {

    public static final String ANNUAL_MONTHLY_DESCRIPTION = "Monthly gross";
    @InjectMocks
    private MonthlyGrossService salaryCalculatorService;



    @Test
    void getDescription() {
        assertThat(salaryCalculatorService.getDescription()).isEqualTo(ANNUAL_MONTHLY_DESCRIPTION);
    }

    @ParameterizedTest
    @CsvSource({"6000, 6000.00", "7000, 7000.00", "15143.99,15143.99"})
    public void getDisabilityZus(BigDecimal input, BigDecimal expected) {
        assertThat(salaryCalculatorService.apply(input)).isEqualTo(expected);
    }
}