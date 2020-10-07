package model;

import java.util.ArrayList;

public class Recipe {
	private int recipeId;
	private String name;
	private String summary;
	private ArrayList<String> ingredient;
	private String NATION_NM;
	private String LEVEL_NM;
	private String image;
	private int userId;
	
	
	public Recipe(int recipeId, String name, String summary, ArrayList<String> ingredient, String NATION_NM,
			String LEVEL_NM, String image, int userId) {
		this.recipeId = recipeId;
		this.name = name;
		this.summary = summary;
		this.ingredient = ingredient;
		this.NATION_NM = NATION_NM;
		this.LEVEL_NM = LEVEL_NM;
		this.image = image;
		this.userId = userId;
	}
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public ArrayList<String> getIngredient() {
		return ingredient;
	}
	public void setIngredient(ArrayList<String> ingredient) {
		this.ingredient = ingredient;
	}
	public String getNATION_NM() {
		return NATION_NM;
	}
	public void setNATION_NM(String nATION_NM) {
		NATION_NM = nATION_NM;
	}
	public String getLEVEL_NM() {
		return LEVEL_NM;
	}
	public void setLEVEL_NM(String lEVEL_NM) {
		LEVEL_NM = lEVEL_NM;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
