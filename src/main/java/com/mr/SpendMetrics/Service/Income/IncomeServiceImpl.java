package com.mr.SpendMetrics.Service.Income;

import com.mr.SpendMetrics.DTO.ExpenseDTO;
import com.mr.SpendMetrics.DTO.IncomeDTO;
import com.mr.SpendMetrics.Entity.Expense;
import com.mr.SpendMetrics.Entity.Income;
import com.mr.SpendMetrics.Repository.ExpenseRepository;
import com.mr.SpendMetrics.Repository.IncomeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;

    public Income addIncome(IncomeDTO incomeDTO){
        return saveOrUpdateIncome(new Income(), incomeDTO);
    }

    private Income saveOrUpdateIncome(Income income, IncomeDTO incomeDTO) {
        income.setTitle(incomeDTO.getTitle());
        income.setDate(incomeDTO.getDate());
        income.setAmount(incomeDTO.getAmount());
        income.setCategory(incomeDTO.getCategory());
        income.setDescription(incomeDTO.getDescription());

        return incomeRepository.save(income);
    }

    public List<IncomeDTO> getAllIncome(){
        return incomeRepository.findAll().stream()
                .sorted(Comparator.comparing(Income::getDate).reversed())
                .map(Income::getIncomeDTO)
                .collect(Collectors.toList());
    }

    public Income getIncomeByID(Long id){
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if(optionalIncome.isPresent()){
            return optionalIncome.get();
        }else{
            throw new EntityNotFoundException("There is no income with id: "+id);
        }
    }

    public Income updateIncome(Long id, IncomeDTO incomeDTO){
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if(optionalIncome.isPresent()){
            return saveOrUpdateIncome(optionalIncome.get(), incomeDTO);
        }else{
            throw new EntityNotFoundException("The income is not present with id: "+id);
        }
    }

    public void deleteIncome(Long id){
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if(optionalIncome.isPresent()){
            incomeRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("The income is not present with id: "+id);
        }
    }

}
