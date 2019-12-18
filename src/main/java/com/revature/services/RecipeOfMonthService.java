package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.RecipeOfMonth;
import com.revature.repositories.RecipeOfMonthRepository;

@Service
public class RecipeOfMonthService {
	
	@Autowired
	private RecipeOfMonthRepository rmr;

	public RecipeOfMonthService() {
		super();
	}
	
	public List<RecipeOfMonth> getRecipesOfMonth() {
		
		return rmr.getRecipesOfMonth();
	}
	
	public RecipeOfMonth getRecipeByMonth(String month) {
		
		return rmr.getRecipeByMonth(month);
	}
	
	
}
