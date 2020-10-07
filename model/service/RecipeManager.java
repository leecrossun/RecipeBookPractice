package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Recipe;
import model.dao.RecipeDAO;

/**
 * ����� ���� API�� ����ϴ� �����ڵ��� ���� �����ϰ� �Ǵ� Ŭ����.
 * UserDAO�� �̿��Ͽ� �����ͺ��̽��� ������ ���� �۾��� �����ϵ��� �ϸ�,
 * �����ͺ��̽��� �����͵��� �̿��Ͽ� �����Ͻ� ������ �����ϴ� ������ �Ѵ�.
 * �����Ͻ� ������ ������ ��쿡�� �����Ͻ� �������� �����ϴ� Ŭ������ 
 * ������ �� �� �ִ�.
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
