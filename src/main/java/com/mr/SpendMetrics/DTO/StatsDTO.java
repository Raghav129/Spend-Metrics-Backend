package com.mr.SpendMetrics.DTO;

import com.mr.SpendMetrics.Entity.Expense;
import com.mr.SpendMetrics.Entity.Income;
import lombok.Data;

@Data
public class StatsDTO {

    private Double income;

    private Double expense;

    private Income latestIncome;

    private Expense latestExpense;

    private Double balance;

    private Double minExpense;

    private Double maxExpense;

    private Double minIncome;

    private Double maxIncome;


}
