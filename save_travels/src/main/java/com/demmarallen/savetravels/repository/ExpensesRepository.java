package com.demmarallen.savetravels.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demmarallen.savetravels.model.Expenses;

public interface ExpensesRepository  extends  CrudRepository<Expenses,Long>{
	List<Expenses> findAll();
}
