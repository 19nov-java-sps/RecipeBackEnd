package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Recipe;
import com.revature.services.RecipeService;

@RestController
@RequestMapping("/recipes")
@CrossOrigin
public class RecipeController {

	@Autowired
	private RecipeService rs;
	
	@GetMapping
	public List<Recipe> getRecipes() {
		
		return rs.getRecipes();
	}
	
	@GetMapping("/users/{user_id}")
	public List<Recipe> getRecipesByUserId(@PathVariable("user_id")int userId) {
		
		return rs.getRecipeByUserId(userId);
	}
		
	@PostMapping
	public int addRecipe(@RequestBody List<Recipe> recipes) {
		
		return rs.addRecipes(recipes);
	}
	
	@DeleteMapping("/{recipe_id}")
	public void deleteRecipe(@PathVariable(value="recipe_id")int recipeId) {
		
		rs.deleteRecipe(recipeId);
	}
	
	
}