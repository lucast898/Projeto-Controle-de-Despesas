package expense.demo;


import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;



@RestController
@RequestMapping("expense")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepo;
    
    @CrossOrigin(origins = "*",  allowedHeaders = "*")
    @GetMapping("/api/expense")
    Iterable<Expense> getAllExpense() {
       return expenseRepo.findAll();
    }
    
    @GetMapping("/api/expense/{id}")
    Optional<Expense> getIdExpense(@PathVariable long id){
        return expenseRepo.findById(id);
    }
    
    @PostMapping("/api/expense")
    Expense createdExpense(@RequestBody Expense e){
        Expense createdExpense = expenseRepo.save(e);
        return createdExpense;
    }
    
    @PutMapping("/api/expense/{expenseId}")
    Expense updateExpense(@RequestBody Expense expenseRequest, @PathVariable long expenseId) {
        Optional<Expense> opt = expenseRepo.findById(expenseId);
        if (opt.isPresent()) {
            Expense expense = opt.get();
            // Atualiza os atributos
            expense.setNameExpense(expenseRequest.getNameExpense());
            expense.setValueExpense(expenseRequest.getValueExpense());
            expense.setValueMensalInstallment(expenseRequest.getValueMensalInstallment());
            expense.setDayPay(expenseRequest.getDayPay());
            expense.setCategoryExpense(expenseRequest.getCategoryExpense());
            
            // Salva as alterações
            return expenseRepo.save(expense);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados da despesa de id: " + expenseId);
    }


    @DeleteMapping(value = "/api/expense/{id}")
    void deleteExpense( @PathVariable long id){
        expenseRepo.deleteById(id);
    }
}
