package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Recipe;
import com.revature.repositories.RecipeRepository;

@Service
public class RecipeService {

	@Autowired
	private RecipeRepository rr;

	public RecipeService() {
		super();
	}
	
	public List<Recipe> getRecipes() {
		
		return rr.getRecipes();
	}
	
	public List<Recipe> getRecipeByUserId(int user_id) {
		
		return rr.getRecipesByUserId(user_id);
	}
		
	public int addRecipes(List<Recipe> recipes) {
		
		return rr.addRecipes(recipes);
	}
	
	public void deleteRecipe(int recipe_id) {
		
		rr.deleteRecipe(recipe_id);
	}
	
	
}
