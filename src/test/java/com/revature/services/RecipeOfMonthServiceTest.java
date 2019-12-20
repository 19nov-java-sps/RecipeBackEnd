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

import com.revature.beans.RecipeOfMonth;
import com.revature.repositories.RecipeOfMonthRepository;

@RunWith(MockitoJUnitRunner.class)
public class RecipeOfMonthServiceTest {
	
	@InjectMocks
	private RecipeOfMonthService rms;
	
	@Mock
	private RecipeOfMonthRepository rmr;
	
	@Test
	public void testingGettingRecipesOfMonth() {
		
		List<RecipeOfMonth> recipesOfMonth = new ArrayList<>();
		
		recipesOfMonth.add(new RecipeOfMonth());
		recipesOfMonth.add(new RecipeOfMonth());
		recipesOfMonth.add(new RecipeOfMonth());
		when(rmr.getRecipesOfMonth()).thenReturn(recipesOfMonth);
		
		assertEquals(rms.getRecipesOfMonth().size(), 3);
	}
	
	@Test
	public void testingGettingRecipesByMonth() {
		
		List<RecipeOfMonth> recipesByMonth = new ArrayList<>();
		
		recipesByMonth.add(new RecipeOfMonth(1,"recipe-name","image-url","source-url",2));
		recipesByMonth.add(new RecipeOfMonth(2,"recipe-name","image-url","source-url",2));
		when(rmr.getRecipesByMonth(2)).thenReturn(recipesByMonth);
		
		assertEquals(rms.getRecipesByMonth(2).size(),2);
	}
}
