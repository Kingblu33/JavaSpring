package com.demmarallen.FruityLoops;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demmarallen.FruityLoops.models.Item;

@Controller
public class FruityLoopsController {
	@RequestMapping("/")
    public String index(Model model) {
        
        ArrayList<Item> fruits = new ArrayList<Item>();
        fruits.add(new Item("Kiwi", 1.5));
        fruits.add(new Item("Mango", 2.0));
        fruits.add(new Item("Goji Berries", 4.0));
        fruits.add(new Item("Guava", .75));
        
     
        // Add fruits your view model here
        for(int i = 0; i < fruits.size();i++) {
        	model.addAttribute("fruits",fruits);
        }
        
        return "index.jsp";
    }
}
