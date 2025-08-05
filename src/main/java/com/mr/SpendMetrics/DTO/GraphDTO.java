package com.mr.SpendMetrics.DTO;

import com.mr.SpendMetrics.Entity.Expense;
import com.mr.SpendMetrics.Entity.Income;
import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {

    private List<Expense> expenseList;

    private List<Income> incomeList;

}
