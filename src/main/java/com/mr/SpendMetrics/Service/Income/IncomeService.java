package com.mr.SpendMetrics.Service.Income;

import com.mr.SpendMetrics.DTO.IncomeDTO;
import com.mr.SpendMetrics.Entity.Income;

import java.util.List;

public interface IncomeService {

    Income addIncome(IncomeDTO incomeDTO);

    List<IncomeDTO> getAllIncome();

    Income getIncomeByID(Long id);

    Income updateIncome(Long id, IncomeDTO incomeDTO);

    void deleteIncome(Long id);



}
