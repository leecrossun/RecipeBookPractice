package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Recipe;
import model.dao.RecipeDAO;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * UserDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
 */
public class RecipeManager {
	private static RecipeManager recipeManager = new RecipeManager();
	private RecipeDAO recipeDAO;

	private RecipeManager() {
		try {
			recipeDAO = new RecipeDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static RecipeManager getInstance() {
		return recipeManager;
	}
	
	public int create(Recipe recipe) throws SQLException{
		if (recipeDAO.existingRecipe(recipe.getName()) == true) {
			return 0;
		}
		return recipeDAO.create(recipe);
	}

	public int update(Recipe recipe) throws SQLException{
		
		return recipeDAO.update(recipe);
	}	

	public int remove(String recipeId) throws SQLException{
		
		return recipeDAO.remove(recipeId);
	}

	public Recipe findRecipe(String recipeId)
		throws SQLException{
		Recipe recipe = recipeDAO.findRecipe(recipeId);
		return recipe;
	}

	public List<Recipe> findRecipeList() throws SQLException {
			return recipeDAO.findRecipeList();
	}
	
	
	public RecipeDAO getRecipeDAO() {
		return this.recipeDAO;
	}
}
