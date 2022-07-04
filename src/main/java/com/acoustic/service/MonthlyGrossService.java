package com.acoustic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@RequiredArgsConstructor
public class MonthlyGrossService implements SalaryCalculatorService{



    @Override
    public String getDescription() {
        return "Monthly gross";
    }

    @Override
    public BigDecimal apply(final BigDecimal grossMonthlySalary) {
        return grossMonthlySalary.setScale(2, RoundingMode.HALF_EVEN);
    }
}
