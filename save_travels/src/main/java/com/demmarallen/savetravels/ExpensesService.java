package com.demmarallen.savetravels;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.demmarallen.savetravels.model.Expenses;
import com.demmarallen.savetravels.repository.ExpensesRepository;

@Service
public class ExpensesService {
	private final ExpensesRepository expensesReposityory;

	public ExpensesService(ExpensesRepository expensesReposityory) {
		this.expensesReposityory = expensesReposityory;
	}

	public ArrayList<Expenses> findAll() {
		return (ArrayList<Expenses>) expensesReposityory.findAll();
	}


	public void deleteById(Long id) {
		expensesReposityory.deleteById(id);
	}
 
	public Expenses newExpense(Expenses e) {
        return expensesReposityory.save(e);
    }

	
	public void delete(Expenses entity) {
		expensesReposityory.delete(entity);
	}
	public Expenses findexpense(Long id) {
        Optional<Expenses> optionalexpense = expensesReposityory.findById(id);
        if(optionalexpense.isPresent()) {
            return optionalexpense.get();
        } else {
            return null;
        }
    }
	
	
	
	
}
