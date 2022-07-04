package com.acoustic.controller;


import com.acoustic.repository.MonthlyGrossRepository;
import com.acoustic.service.SalaryCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;


@RestController
@RequestMapping("/monthlyGross")
@RequiredArgsConstructor
@Validated
public class MonthlyGrossController {

    private final MonthlyGrossRepository monthlyGrossRepository;
    private final SalaryCalculatorService salaryCalculatorService;


    @PostMapping("/getMonthlyGross/{grossMonthlySalary}")
    public Map<String, BigDecimal> calculateTotalZus(@PathVariable @Min(2000)BigDecimal grossMonthlySalary){
        var monthlyNet = salaryCalculatorService.apply(grossMonthlySalary);
        this.monthlyGrossRepository.save(com.acoustic.entity.MonthlyGrossController.builder().monthlyNetAmount(monthlyNet).build());
        return new LinkedHashMap<>(Map.of(salaryCalculatorService.getDescription(), monthlyNet));
    }
}
