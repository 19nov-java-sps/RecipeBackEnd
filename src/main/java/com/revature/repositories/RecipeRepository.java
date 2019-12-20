package com.revature.repositories;

import java.util.List;

import com.revature.beans.Recipe;

public interface RecipeRepository {
	
	public List<Recipe> getRecipes();
	public List<Recipe> getRecipesByUserId(int user_id);
	public int addRecipes(List<Recipe> recipes);
	public void deleteRecipe(int recipe_id);
}
