package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RecipeProcess;
import model.dao.RecipeProcessDAO;

/**
 * ����� ���� API�� ����ϴ� �����ڵ��� ���� �����ϰ� �Ǵ� Ŭ����.
 * UserDAO�� �̿��Ͽ� �����ͺ��̽��� ������ ���� �۾��� �����ϵ��� �ϸ�,
 * �����ͺ��̽��� �����͵��� �̿��Ͽ� �����Ͻ� ������ �����ϴ� ������ �Ѵ�.
 * �����Ͻ� ������ ������ ��쿡�� �����Ͻ� �������� �����ϴ� Ŭ������ 
 * ������ �� �� �ִ�.
 */
public class RecipeProcessManager {
	private static RecipeProcessManager recipeProcessManager = new RecipeProcessManager();
	private RecipeProcessDAO recipeProcessDAO;

	private RecipeProcessManager() {
		try {
			recipeProcessDAO = new RecipeProcessDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static RecipeProcessManager getInstance() {
		return recipeProcessManager;
	}
	
	public int create(RecipeProcess recipeProcess) throws SQLException{
		
		return recipeProcessDAO.create(recipeProcess);
	}

	public int update(RecipeProcess recipeProcess) throws SQLException{
		
		return recipeProcessDAO.update(recipeProcess);
	}	

	public int remove(String recipeId) throws SQLException{
		
		return recipeProcessDAO.remove(recipeId);
	}

	public ArrayList<RecipeProcess> findProcess(String recipeId)
		throws SQLException{
		ArrayList<RecipeProcess> process = recipeProcessDAO.findRecipeProcess(recipeId);
		return process;
	}

	public List<RecipeProcess> findRecipeProcessList() throws SQLException {
			return recipeProcessDAO.findRecipeProcessList();
	}
	
	
	public RecipeProcessDAO getRecipeProcessDAO() {
		return this.recipeProcessDAO;
	}
}
