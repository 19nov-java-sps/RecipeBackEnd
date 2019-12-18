package com.revature.repositories.Impl;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.Recipe;
import com.revature.repositories.RecipeRepository;
import com.revature.util.HibernateUtil;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository {
	
	@Override
	public List<Recipe> getRecipes() {
		
		try(Session s = HibernateUtil.getSession()) {
			
			String hql = "from Recipe";
			Query<Recipe> q = s.createQuery(hql, Recipe.class);
			List<Recipe> recipes = q.getResultList();
			if (recipes.size() != 0) {
				return recipes;
			}
			return null;
		}
	}
	
	@Override
	public List<Recipe> getRecipesByUserId(int user_id) {
		
		try(Session s = HibernateUtil.getSession()) {
			
			String hql = "from Recipe where user_id = :idVar";
			Query<Recipe> q = s.createQuery(hql, Recipe.class);
			q.setParameter("idVar", user_id);
			List<Recipe> r = q.getResultList();
			if (r.size() != 0) {
				return r;
			}
			return null;
		}
	}

	@Override
	public int addRecipe(Recipe r) {
		
		int recipeCreated = 0;
		try(Session s = HibernateUtil.getSession()) {
			
			Transaction tx = s.beginTransaction();
			recipeCreated = (int) s.save(r);
			tx.commit();
			return recipeCreated;
			
		}
	}

	@Override
	public void deleteRecipe(int recipe_id) {
		
		try(Session s = HibernateUtil.getSession()) {
			
			Transaction tx = s.beginTransaction();
			s.delete(new Recipe(recipe_id));
			tx.commit();
		}
	}

}
