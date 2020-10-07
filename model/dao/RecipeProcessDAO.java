package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RecipeProcess;

//Ŭ�������� process��� �ϸ� process��ü ������ �� java.lang.process�� �����ؼ� �̸��� �ٲ���ϴ�. 
/**
 * �丮���� ������ ���� �����ͺ��̽� �۾��� �����ϴ� DAO Ŭ����
 * RECIPEPROCESSINFO ���̺� �丮���� ������ �߰�, ����, ����, �˻� ���� 
 */
public class RecipeProcessDAO {
	private JDBCUtil jdbcUtil = null;

	public RecipeProcessDAO() {
		jdbcUtil = new JDBCUtil(); // JDBCUtil ��ü ����
	}

	/**
	 * ���İ��� ���� ���̺� ���ο� ��� �߰�.
	 */
	public int create(RecipeProcess process) throws SQLException {
		String sql = "INSERT INTO RECIPEPROCESSTINFO(COOKINGCONTENTS, RECIPEID) VALUES (?,?)";
		Object[] param = new Object[] {process.getCookingContents(), process.getRecipeId() };
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
	 * ������ ���İ��� ������ ����.
	 */
	public int update(RecipeProcess process) throws SQLException {
		String sql = "UPDATE RECIPEPROCESSINFO " + "SET COOKINGCONTENTS=? " + "WHERE COOKINGNO=? AND RECIPEID=?";
		Object[] param = new Object[] { process.getCookingContents(), process.getCookingNo(), process.getRecipeId()};

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
	 * ������ ID�� �ش��ϴ� ���İ����� ����.
	 */
	public int remove(String recipeId) throws SQLException {
		String sql = "DELETE FROM RECIPEPROCESSINFO WHERE RECIPEID=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { recipeId }); // JDBCUtil�� delete���� �Ű� ���� ����

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

	public ArrayList<RecipeProcess> findRecipeProcess(String recipeId) throws SQLException {
		String sql = "SELECT * " + "FROM RECIPEPROCESSINFO " + "WHERE RECIPEID=? ORDER BY COOKINGNO";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { recipeId }); // JDBCUtil�� query���� �Ű� ���� ����
		
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query ����
			ArrayList<RecipeProcess> processList = new ArrayList<>(); 
			while (rs.next()) { // ��� ���� �߰�
				RecipeProcess process = new RecipeProcess( // recipe ��ü�� �����Ͽ� ��� ������ ����
						rs.getInt("COOKINGNO"), rs.getString("COOKINGCONTENTS"), rs.getInt("RECIPEID"));
				return processList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource ��ȯ
		}
		return null;
	}

	/**
	 * ��ü �丮���� ������ �˻��Ͽ� List�� ���� �� ��ȯ
	 */
	public List<RecipeProcess> findRecipeProcessList() throws SQLException {
		String sql = "SELECT * " + "FROM RECIPEPROCESSINFO " + "ORDER BY RECIPEID, COOKINGNO";
		jdbcUtil.setSqlAndParameters(sql, null); // JDBCUtil�� query�� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query ����
			List<RecipeProcess> processList = new ArrayList<RecipeProcess>(); // RecipeProcess���� ����Ʈ ����
			while (rs.next()) {
				RecipeProcess process = new RecipeProcess( // recipe ��ü�� �����Ͽ� ���� ���� ������ ����
						rs.getInt("COOKINGNO"), rs.getString("COOKINGCONTENTS"), rs.getInt("RECIPEID"));
				processList.add(process); // List�� recipe ��ü ����
			}
			return processList;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource ��ȯ
		}
		return null;
	}
}
