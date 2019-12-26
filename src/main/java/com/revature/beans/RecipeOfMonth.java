package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="recipe_of_month_table")
public class RecipeOfMonth implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="recipe_id")
	private int id;
	private String recipeName;
	private String imageUrl;
	private String sourceUrl;
	
	@Column(name="month_number")
	private int month;
	
	public RecipeOfMonth() {
		super();
	}

	public RecipeOfMonth(int id, String recipeName, String imageUrl, String sourceUrl, int month) {
		super();
		this.id = id;
		this.recipeName = recipeName;
		this.imageUrl = imageUrl;
		this.sourceUrl = sourceUrl;
		this.month = month;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + month;
		result = prime * result + ((recipeName == null) ? 0 : recipeName.hashCode());
		result = prime * result + ((sourceUrl == null) ? 0 : sourceUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipeOfMonth other = (RecipeOfMonth) obj;
		if (id != other.id)
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} 
		else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (month != other.month)
			return false;
		if (recipeName == null) {
			if (other.recipeName != null)
				return false;
		} 
		else if (!recipeName.equals(other.recipeName))
			return false;
		if (sourceUrl == null) {
			if (other.sourceUrl != null)
				return false;
		} 
		else if (!sourceUrl.equals(other.sourceUrl))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecipeOfMonth [id=" + id + ", recipeName=" + recipeName + ", imageUrl=" + imageUrl + ", sourceUrl="
				+ sourceUrl + ", month=" + month + "]";
	}

}
