package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class RecipeController {

	@Autowired
	private RecipeService rs;
	
	@GetMapping
	public List<Recipe> getRecipes() {
		
		return rs.getRecipes();
	}
	
	@GetMapping("/users/{user_id}")
	public List<Recipe> getRecipesByUserId(@PathVariable("user_id")int user_id) {
		
		return rs.getRecipeByUserId(user_id);
	}
		
	@PostMapping
	public int addRecipe(@RequestBody Recipe r) {
		
		return rs.addRecipe(r);
	}
	
	@DeleteMapping("/{recipe_id}")
	public void deleteRecipe(@PathVariable(value="recipe_id")int recipe_id) {
		
		rs.deleteRecipe(recipe_id);
	}
	
	
}