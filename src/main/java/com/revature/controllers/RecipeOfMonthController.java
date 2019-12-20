package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.RecipeOfMonth;
import com.revature.services.RecipeOfMonthService;

@RestController
@RequestMapping("/recipes-of-month")
@CrossOrigin
public class RecipeOfMonthController {
	
	@Autowired
	private RecipeOfMonthService rms;
	
	@GetMapping
	public List<RecipeOfMonth> getRecipesOfMonth() {
		
		return rms.getRecipesOfMonth();
	}
	
	@GetMapping("/{month}")
	public List<RecipeOfMonth> getRecipesByMonth(@PathVariable("month")int month) {
		
		return rms.getRecipesByMonth(month);
	}
	
}
