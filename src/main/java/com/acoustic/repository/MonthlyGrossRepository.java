package com.acoustic.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.acoustic.entity.MonthlyGrossController;

@Repository
public interface MonthlyGrossRepository extends JpaRepository<MonthlyGrossController, Long> {



}
