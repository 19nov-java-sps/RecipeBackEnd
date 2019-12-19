package com.revature.repositories;

import java.util.List;

import com.revature.beans.RecipeOfMonth;

public interface RecipeOfMonthRepository {
	
	public List<RecipeOfMonth> getRecipesOfMonth();
	public RecipeOfMonth getRecipeByMonth(int month);
	
}
