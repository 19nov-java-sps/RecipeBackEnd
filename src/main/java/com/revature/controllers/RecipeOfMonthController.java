package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.RecipeOfMonth;
import com.revature.services.RecipeOfMonthService;

@RestController
@RequestMapping("/recipe-of-month")
public class RecipeOfMonthController {
	
	@Autowired
	private RecipeOfMonthService rms;
	
	@GetMapping
	public List<RecipeOfMonth> getRecipesOfMonth() {
		
		return rms.getRecipesOfMonth();
	}
	
	@GetMapping("/{month}")
	public RecipeOfMonth getRecipeByMonth(@PathVariable("month")int month) {
		
		return rms.getRecipeByMonth(month);
	}
	
}
