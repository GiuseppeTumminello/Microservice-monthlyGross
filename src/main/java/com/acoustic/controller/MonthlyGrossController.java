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
import java.util.Map;


@RestController
@RequestMapping("/monthlyGross")
@RequiredArgsConstructor
@Validated
public class MonthlyGrossController {

    public static final String DESCRIPTION = "description";
    public static final String VALUE = "value";

    private final MonthlyGrossRepository monthlyGrossRepository;
    private final SalaryCalculatorService salaryCalculatorService;


    @PostMapping("/getMonthlyGross/{grossMonthlySalary}")
    public Map<String, String> calculateMonthlyGross(@PathVariable @Min(2000)BigDecimal grossMonthlySalary){
        var monthlyGross = this.salaryCalculatorService.apply(grossMonthlySalary);
        this.monthlyGrossRepository.save(com.acoustic.entity.MonthlyGrossController.builder().monthlyGrossAmount(monthlyGross).build());
        return Map.of(DESCRIPTION,this.salaryCalculatorService.getDescription(), VALUE, String.valueOf(monthlyGross));
    }
}
