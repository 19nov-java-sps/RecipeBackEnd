package com.revature.repositories;

import java.util.List;

import com.revature.beans.Recipe;

public interface RecipeRepository {
	
	public List<Recipe> getRecipes();
	public List<Recipe> getRecipesByUserId(int user_id);
	public int addRecipe(Recipe r);
	public void deleteRecipe(int recipe_id);
}
