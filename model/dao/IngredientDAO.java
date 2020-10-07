package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Ingredient;

/**
 * ��� ������ ���� �����ͺ��̽� �۾��� �����ϴ� DAO Ŭ���� INGREDIENTINFO ���̺� ����� ������ �߰�, ����, ����, �˻�
 * ����
 */
public class IngredientDAO {
	private JDBCUtil jdbcUtil = null;

	public IngredientDAO() {
		jdbcUtil = new JDBCUtil(); // JDBCUtil ��ü ����
	}

	/**
	 * ��� ���� ���̺� ���ο� ��� �߰�.
	 */
	public int create(Ingredient ingredient) throws SQLException {
		String sql = "INSERT INTO INGREDIENTINFO(NAME) VALUES (?)";
		Object[] param = new Object[] { ingredient.getName() };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil �� insert���� �Ű� ���� ����

		try {
			int result = jdbcUtil.executeUpdate(); // insert �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource ��ȯ
		}
		return 0;
	}

	/**
	 * ������ ��� ������ ����.
	 */
	public int update(Ingredient ingredient) throws SQLException {
		String sql = "UPDATE INGREDIENTINFO " + "SET NAME=? " + "WHERE INGREDIENTID=?";
		Object[] param = new Object[] { ingredient.getName(), ingredient.getIngredientId() };

		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil�� update���� �Ű� ���� ����

		try {
			int result = jdbcUtil.executeUpdate(); // update �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource ��ȯ
		}
		return 0;
	}

	/**
	 * ��� ID�� �ش��ϴ� ��Ḧ ����.
	 */
	public int remove(String ingredientId) throws SQLException {
		String sql = "DELETE FROM INGREDIENTINFO WHERE INGREDIENTID=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { ingredientId }); // JDBCUtil�� delete���� �Ű� ���� ����

		try {
			int result = jdbcUtil.executeUpdate(); // delete �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource ��ȯ
		}
		return 0;
	}

	public Ingredient findIngredient(String ingredientId) throws SQLException {
		String sql = "SELECT * " + "FROM INGREDIENTINFO " + "WHERE INGREDIENTID=? ";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { ingredientId }); // JDBCUtil�� query���� �Ű� ���� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query ����
			if (rs.next()) { // ��� ���� �߰�
				Ingredient ingredient = new Ingredient( // recipe ��ü�� �����Ͽ� ��� ������ ����
						rs.getInt("INGREDIENTID"), rs.getString("NAME"));
				return ingredient;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource ��ȯ
		}
		return null;
	}

	/**
	 * ��ü ��� ������ �˻��Ͽ� List�� ���� �� ��ȯ
	 */
	public List<Ingredient> findIngredientList() throws SQLException {
		String sql = "SELECT * " + "FROM INGREDIENTINFO " + "ORDER BY INGREDIENTID";
		jdbcUtil.setSqlAndParameters(sql, null); // JDBCUtil�� query�� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query ����
			List<Ingredient> ingredientList = new ArrayList<Ingredient>(); // Ingredient���� ����Ʈ ����
			while (rs.next()) {
				Ingredient ingredient = new Ingredient( // recipe ��ü�� �����Ͽ� ���� ���� ������ ����
						rs.getInt("INGREDIENTID"), rs.getString("NAME"));
				ingredientList.add(ingredient); // List�� recipe ��ü ����
			}
			return ingredientList;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource ��ȯ
		}
		return null;
	}
	
	/**
	 * ��ü ��� ������ �˻��� �� ���� �������� �������� ����� ����� ���� �̿��Ͽ�
	 * �ش��ϴ� ��� �������� List�� �����Ͽ� ��ȯ.
	 */
	public List<Ingredient> findIngredientList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT * " 
					+ "FROM INGREDIENTINFO "
					+ "ORDER BY INGREDIENTID";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil�� query�� ����
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll ����
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query ����			
			int start = ((currentPage-1) * countPerPage) + 1;	// ����� ������ �� ��ȣ ���
			if ((start >= 0) && rs.absolute(start)) {			// Ŀ���� ���� ������ �̵�
				List<Ingredient> ingredientList = new ArrayList<Ingredient>();	// User���� ����Ʈ ����
				do {
					Ingredient ingredient = new Ingredient(			// User ��ü�� �����Ͽ� ���� ���� ������ ����
						rs.getInt("INGREDIENTID"),
						rs.getString("NAME"));
					ingredientList.add(ingredient);							// ����Ʈ�� User ��ü ����
				} while ((rs.next()) && (--countPerPage > 0));		
				return ingredientList;							
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
	public boolean existingIngredient(String name) throws SQLException {
		String sql = "SELECT count(*) FROM INGREDIENTINFO WHERE NAME=?";      
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
