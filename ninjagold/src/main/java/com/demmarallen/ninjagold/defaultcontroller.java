package com.demmarallen.ninjagold;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class defaultcontroller {
	@GetMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("totalGold") == null) {
			session.setAttribute("totalGold", 0);
			session.setAttribute("activities", new ArrayList<String>());
			session.setAttribute("messages", new ArrayList<String>());
		} 
		return "index.jsp";
	}

	@PostMapping("/process_money")
	public String  processMoney 
	(
		@RequestParam(value="building") 
		String building, 
		HttpSession session
	) 
	{
		if(building.equals("farm")) {
			int max = 20;
			int min = 10;
			Random r = new Random();
			int n = r.nextInt(max + 1 - min) + min;
			System.out.println(n);
			
			session.setAttribute("totalGold", (Integer) session.getAttribute("totalGold") + n);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("E, MMMM d, y 'at' h:mm a");
			
			String formattedDate = dateFormat.format(new java.util.Date());
			
			// add the result to the beginning of the ArrayList. Display in activities box.
			@SuppressWarnings("unchecked")
			ArrayList<String> temp_activities = (ArrayList<String>) session.getAttribute("activities");
			
			temp_activities.add(0, "Earned " + n + " gold from the farm! " + formattedDate);
			session.setAttribute("activities", temp_activities);
		} 
		else if(building.equals("cave")) 
		{	
			int max = 10;
			
			int min = 5;
			Random r = new Random();
			int n = r.nextInt(max + 1 - min) + min;
			
			session.setAttribute("totalGold", (Integer) session.getAttribute("totalGold") + n);
			SimpleDateFormat dateFormat = new SimpleDateFormat("E, MMMM d, y 'at' h:mm a");
			
			String formattedDate = dateFormat.format(new java.util.Date());
			
			// add the result to the beginning of the ArrayList. Display in activities box.
			@SuppressWarnings("unchecked")
			ArrayList<String> temp_activities = (ArrayList<String>) session.getAttribute("activities");
			
			temp_activities.add(0, "Earned " + n + " gold from the cave! " + formattedDate);
			session.setAttribute("activities", temp_activities);
		} 
		else if(building.equals("house")) 
		{
			
			int max = 5;
			int min = 2;
			Random r = new Random();
			int n = r.nextInt(max + 1 - min) + min;
			session.setAttribute("totalGold", (Integer) session.getAttribute("totalGold") + n);
			SimpleDateFormat dateFormat = new SimpleDateFormat("E, MMMM d, y 'at' h:mm a");
			
			String formattedDate = dateFormat.format(new java.util.Date());
			
			// add the result to the beginning of the ArrayList. Display in activities box.
			ArrayList<String> temp_activities = (ArrayList<String>) session.getAttribute("activities");
			temp_activities.add(0, "Earned " + n + " gold from the house! " + formattedDate);
			
			session.setAttribute("activities", temp_activities);
		} 
		else if(building.equals("casino")) 
			
		{
			Random r = new Random();
			int max = 50;
			int min = -50;
			int n = r.nextInt(max + 1 - min) + min;
			System.out.println(n);
			session.setAttribute("totalGold", (Integer) session.getAttribute("totalGold") + n);
			SimpleDateFormat dateFormat = new SimpleDateFormat("E, MMMM d, y 'at' h:mm a");
			String formattedDate = dateFormat.format(new java.util.Date());
			// add the result to the beginning of the ArrayList. Display in activities box.
			@SuppressWarnings("unchecked")
			ArrayList<String> temp_activities = (ArrayList<String>) session.getAttribute("activities");
			if(n < 0) {
				temp_activities.add(0, "Lost " + (-n) + " gold from the casino! " + formattedDate);
			} else {
				temp_activities.add(0, "Earned " + n + " gold from the casino! " + formattedDate);
			}
			session.setAttribute("activities", temp_activities);
		}
		return "redirect:/";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}

