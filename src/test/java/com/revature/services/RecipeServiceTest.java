package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.beans.Recipe;
import com.revature.repositories.RecipeRepository;

@RunWith(MockitoJUnitRunner.class)
public class RecipeServiceTest {
	
	@InjectMocks
	private RecipeService rs;
	
	@Mock
	private RecipeRepository rr;
	
	@Test
	public void testingGettingRecipes() {
		
		List<Recipe> recipes = new ArrayList<>();
		
		recipes.add(new Recipe());
		recipes.add(new Recipe());
		recipes.add(new Recipe());
		when(rr.getRecipes()).thenReturn(recipes);
		
		assertEquals(rs.getRecipes().size(),3);
	}
	
	@Test
	public void testingGettingRecipesByUserId() {
		
		List<Recipe> recipesById = new ArrayList<>();
		
		recipesById.add(new Recipe(1,1234,1));
		recipesById.add(new Recipe(2,1235,1));
		when(rr.getRecipesByUserId(1)).thenReturn(recipesById);
		
		assertEquals(rs.getRecipeByUserId(1).size(), 2);
	}
	
	@Test
	public void testingAddingRecipe() {
		
		int expected = 1;
		List<Recipe> recipes = new ArrayList<>();
		recipes.add(new Recipe());
		recipes.add(new Recipe());
		when(rr.addRecipes(recipes)).thenReturn(1);
		int actual = rs.addRecipes(recipes);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testingDeletingRecipe() {
		
		
	}
}
