package com.demmarallen.savetravels.controller;


import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demmarallen.savetravels.ExpensesService;
import com.demmarallen.savetravels.model.Expenses;

@Controller
public class ExpensesController {
	@Autowired
	ExpensesService expenses;
	
	@GetMapping("/")
	public String formpage(
			@ModelAttribute("expense") 	Expenses expense,
			Model model
			) 
	{
		ArrayList<Expenses> exp = expenses.findAll();
		model.addAttribute("expenses", exp);
		System.out.println("made it inside of get");
		return "index.jsp";
	}
	@PostMapping("/newexpense")
	 public String create(@Valid @ModelAttribute("expense") Expenses expense,BindingResult result, Model model) {
        if (result.hasErrors()) {
        	ArrayList<Expenses> exp = expenses.findAll();
    		model.addAttribute("expenses", exp);
            return "index.jsp";
        } else {
            expenses.newExpense(expense);
            return "redirect:/";
        }
	}
	 @RequestMapping("/expense/edit/{id}")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Expenses exp = expenses.findexpense(id);
	        model.addAttribute("expenses", exp);
	        return "edit.jsp";
	    }
	    
	    @RequestMapping(value="/expense/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("expenses") Expenses expense, BindingResult result) {
	        if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	            expenses.newExpense(expense);
	            return "redirect:/";
	        }
	    }
	    
	    @GetMapping("/expense/delete/{id}")
	    public String destroy(@PathVariable("id") Long id) {
	        expenses.deleteById(id);
	        return "redirect:/";
	    } 
	    
	    @GetMapping("/expense/showone/{id}")
	    public String showone(@PathVariable("id") Long id, Model model) {
	        Expenses exp=expenses.findexpense(id);
	        
	        model.addAttribute("expenses",exp);
	        
	        return "show.jsp";
	    }   
	    
	    
	   
}
