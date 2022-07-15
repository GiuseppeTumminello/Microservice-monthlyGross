package com.acoustic.controller;


import com.acoustic.repository.MonthlyGrossRepository;
import com.acoustic.service.SalaryCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Map;


@RestController
@RequestMapping("/monthly-gross")
@RequiredArgsConstructor
@Validated
@CrossOrigin
public class MonthlyGrossController {

    public static final String DESCRIPTION = "description";
    public static final String VALUE = "value";
    public static final int MINIMUM_GROSS = 2000;

    private final MonthlyGrossRepository monthlyGrossRepository;
    private final SalaryCalculatorService salaryCalculatorService;


    @PostMapping("/calculation/{grossMonthlySalary}")
    public Map<String, String> calculateMonthlyGross(@PathVariable @Min(MINIMUM_GROSS)BigDecimal grossMonthlySalary){
        var monthlyGross = this.salaryCalculatorService.apply(grossMonthlySalary);
        this.monthlyGrossRepository.save(com.acoustic.entity.MonthlyGrossController.builder().monthlyGrossAmount(monthlyGross).build());
        return Map.of(DESCRIPTION,this.salaryCalculatorService.getDescription(), VALUE, String.valueOf(monthlyGross));
    }
}
