package com.mr.SpendMetrics.Service.Expense;

import com.mr.SpendMetrics.DTO.ExpenseDTO;
import com.mr.SpendMetrics.Entity.Expense;

import java.util.List;

public interface ExpenseService {

    Expense addExpense(ExpenseDTO expenseDTO);

    List<Expense> getAllExpense();

    Expense getExpenseByID(Long id);

    Expense updateExpense(Long id, ExpenseDTO expenseDTO);

    void deleteExpense(Long id);

}
