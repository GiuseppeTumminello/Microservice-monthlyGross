package com.acoustic.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MonthlyGrossController {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private BigDecimal monthlyNetAmount;




}
