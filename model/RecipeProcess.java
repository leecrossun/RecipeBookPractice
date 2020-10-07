package model;

public class RecipeProcess {
	private int cookingNo;
	private String CookingContents;
	private int recipeId;
	
	public RecipeProcess(int cookingNo, String cookingContents, int recipeId) {
		this.cookingNo = cookingNo;
		CookingContents = cookingContents;
		this.recipeId = recipeId;
	}
	public int getCookingNo() {
		return cookingNo;
	}
	public void setCookingNo(int cookingNo) {
		this.cookingNo = cookingNo;
	}
	public String getCookingContents() {
		return CookingContents;
	}
	public void setCookingContents(String cookingContents) {
		CookingContents = cookingContents;
	}
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	
}
