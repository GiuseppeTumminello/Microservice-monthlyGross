package com.acoustic.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
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
