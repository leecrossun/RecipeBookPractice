package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Ingredient;
import model.dao.IngredientDAO;

/**
 * ����� ���� API�� ����ϴ� �����ڵ��� ���� �����ϰ� �Ǵ� Ŭ����.
 * UserDAO�� �̿��Ͽ� �����ͺ��̽��� ������ ���� �۾��� �����ϵ��� �ϸ�,
 * �����ͺ��̽��� �����͵��� �̿��Ͽ� �����Ͻ� ������ �����ϴ� ������ �Ѵ�.
 * �����Ͻ� ������ ������ ��쿡�� �����Ͻ� �������� �����ϴ� Ŭ������ 
 * ������ �� �� �ִ�.
 */
public class IngredientManager {
	private static IngredientManager ingredientManager = new IngredientManager();
	private IngredientDAO ingredientDAO;

	private IngredientManager() {
		try {
			ingredientDAO = new IngredientDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static IngredientManager getInstance() {
		return ingredientManager;
	}
	
	public int create(Ingredient ingredient) throws SQLException{
		if (ingredientDAO.existingIngredient(ingredient.getName()) == true) {
			return 0;
		}
		return ingredientDAO.create(ingredient);
	}

	public int update(Ingredient ingredient) throws SQLException{
		
		return ingredientDAO.update(ingredient);
	}	

	public int remove(String ingredientId) throws SQLException{
		
		return ingredientDAO.remove(ingredientId);
	}

	public Ingredient findIngredient(String ingredientId)
		throws SQLException{
		Ingredient ingredient = ingredientDAO.findIngredient(ingredientId);
		return ingredient;
	}

	public List<Ingredient> findIngredientList() throws SQLException {
			return ingredientDAO.findIngredientList();
	}
	
	
	public IngredientDAO getIngredientDAO() {
		return this.ingredientDAO;
	}
}
