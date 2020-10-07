package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.util.buf.StringUtils;

import model.Ingredient;
import model.Recipe;
/**
 * ������ ������ ���� �����ͺ��̽� �۾��� �����ϴ� DAO Ŭ����
 * RECIPEINFO ���̺� ����� ������ �߰�, ����, ����, �˻� ���� 
 */
public class RecipeDAO {
private JDBCUtil jdbcUtil = null;
	
	public RecipeDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil ��ü ����
	}
		
	/**
	 * ������ ���� ���̺� ���ο� ������ ����.
	 */
	public int create(Recipe recipe) throws SQLException {
		String sql = "INSERT INTO RECIPEINFO(NAME, SUMMARY, INGREDIENT,NATION_NM, LEVEL_NM, IMAGE, USERID) VALUES (?, ?, ?, ?, ?, ?, ?)";	
		String ingredientList = StringUtils.join(recipe.getIngredient(),','); 
		Object[] param = new Object[] {recipe.getName(), recipe.getSummary(), ingredientList, recipe.getNATION_NM(), recipe.getLEVEL_NM(), recipe.getImage(), recipe.getUserId()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil �� insert���� �Ű� ���� ����
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;			
	}

	/**
	 * ������ ������ ������ ����.
	 */
	public int update(Recipe recipe) throws SQLException {
		String sql = "UPDATE RECIPEINFO "
					+ "SET NAME=?, SUMMARY=?, INGREDIENT=?, NATION_NM=?, LEVEL_NM=?, IMAGE=?, USERID=? "
					+ "WHERE RECIPEID=?";
		String ingredientList = StringUtils.join(recipe.getIngredient(),','); 
		Object[] param = new Object[] {recipe.getName(),recipe.getSummary(),ingredientList, recipe.getNATION_NM(), recipe.getLEVEL_NM(), recipe.getImage(), recipe.getUserId(), recipe.getRecipeId()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil�� update���� �Ű� ���� ����
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;
	}

	/**
	 * ������ ID�� �ش��ϴ� ����ڸ� ����.
	 */
	public int remove(String recipeId) throws SQLException {
		String sql = "DELETE FROM RECIPEINFO WHERE RECIPEID=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {recipeId});	// JDBCUtil�� delete���� �Ű� ���� ����

		try {				
			int result = jdbcUtil.executeUpdate();	// delete �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;
	}

	/**
	 * �־��� ������ ID�� �ش��ϴ� ������ ������ �����ͺ��̽����� ã�� RECIPE ������ Ŭ������ 
	 * �����Ͽ� ��ȯ.
	 */
	public Recipe findRecipe(String recipeId) throws SQLException {
        String sql = "SELECT * "
        			+ "FROM RECIPEINFO "
        			+ "WHERE RECIPEID=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {recipeId});	// JDBCUtil�� query���� �Ű� ���� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����
			if (rs.next()) {						// ������ ���� �߰�
				Recipe recipe = new Recipe(		// Recipe ��ü�� �����Ͽ� �л� ������ ����
					rs.getInt("RECIPEID"),
					rs.getString("NAME"),
					rs.getString("SUMMARY"),
					new ArrayList<>(Arrays.asList(rs.getString("recipe").split(","))),
					rs.getString("NATION_NM"),
					rs.getString("LEVEL_NM"),					
					rs.getString("IMAGE"),
					rs.getInt("USERID"));
				return recipe;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}

	/**
	 * ��ü ������ ������ �˻��Ͽ� List�� ���� �� ��ȯ
	 */
	public List<Recipe> findRecipeList() throws SQLException {
        String sql = "SELECT * " 
        		   + "FROM RECIPEINFO "
        		   + "ORDER BY RECIPEID";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil�� query�� ����
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query ����			
			List<Recipe> recipeList = new ArrayList<Recipe>();	// Recipe���� ����Ʈ ����
			while (rs.next()) {
				Recipe recipe = new Recipe(			// Recipe ��ü�� �����Ͽ� ���� ���� ������ ����
						rs.getInt("RECIPEID"),
						rs.getString("NAME"),
						rs.getString("SUMMARY"),
						new ArrayList<>(Arrays.asList(rs.getString("recipe").split(","))),
						rs.getString("NATION_NM"),
						rs.getString("LEVEL_NM"),					
						rs.getString("IMAGE"),
						rs.getInt("USERID"));	
						recipeList.add(recipe);// List�� Recipe ��ü ����
			}		
			return recipeList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
	/**
	 * ��ü ��� ������ �˻��� �� ���� �������� �������� ����� ����� ���� �̿��Ͽ�
	 * �ش��ϴ� ��� �������� List�� �����Ͽ� ��ȯ.
	 */
	public List<Recipe> findRecipeList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT * " 
					+ "FROM RECIPEINFO "
					+ "ORDER BY RECIPEID";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil�� query�� ����
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll ����
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query ����			
			int start = ((currentPage-1) * countPerPage) + 1;	// ����� ������ �� ��ȣ ���
			if ((start >= 0) && rs.absolute(start)) {			// Ŀ���� ���� ������ �̵�
				List<Recipe> recipeList = new ArrayList<Recipe>();	// User���� ����Ʈ ����
				do {
					Recipe recipe = new Recipe(		// Recipe ��ü�� �����Ͽ� �л� ������ ����
							rs.getInt("RECIPEID"),
							rs.getString("NAME"),
							rs.getString("SUMMARY"),
							new ArrayList<>(Arrays.asList(rs.getString("recipe").split(","))),
							rs.getString("NATION_NM"),
							rs.getString("LEVEL_NM"),					
							rs.getString("IMAGE"),
							rs.getInt("USERID"));						// ����Ʈ�� User ��ü ����
				} while ((rs.next()) && (--countPerPage > 0));		
				return recipeList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}

	/**
	 * �־��� ����̸��� �ش��ϴ� ��ᰡ �����ϴ��� �˻� 
	 */
	public boolean existingRecipe(String name) throws SQLException {
		String sql = "SELECT count(*) FROM RECIPEINFO WHERE NAME=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {name});	// JDBCUtil�� query���� �Ű� ���� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return false;
	}

}
