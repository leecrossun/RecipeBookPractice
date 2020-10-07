package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Ingredient;
import model.dao.IngredientDAO;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * UserDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
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
