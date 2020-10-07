package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Ingredient;

/**
 * 재료 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스 INGREDIENTINFO 테이블에 사용자 정보를 추가, 수정, 삭제, 검색
 * 수행
 */
public class IngredientDAO {
	private JDBCUtil jdbcUtil = null;

	public IngredientDAO() {
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성
	}

	/**
	 * 재료 관리 테이블에 새로운 재료 추가.
	 */
	public int create(Ingredient ingredient) throws SQLException {
		String sql = "INSERT INTO INGREDIENTINFO(NAME) VALUES (?)";
		Object[] param = new Object[] { ingredient.getName() };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil 에 insert문과 매개 변수 설정

		try {
			int result = jdbcUtil.executeUpdate(); // insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}

	/**
	 * 기존의 재료 정보를 수정.
	 */
	public int update(Ingredient ingredient) throws SQLException {
		String sql = "UPDATE INGREDIENTINFO " + "SET NAME=? " + "WHERE INGREDIENTID=?";
		Object[] param = new Object[] { ingredient.getName(), ingredient.getIngredientId() };

		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil에 update문과 매개 변수 설정

		try {
			int result = jdbcUtil.executeUpdate(); // update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}

	/**
	 * 재료 ID에 해당하는 재료를 삭제.
	 */
	public int remove(String ingredientId) throws SQLException {
		String sql = "DELETE FROM INGREDIENTINFO WHERE INGREDIENTID=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { ingredientId }); // JDBCUtil에 delete문과 매개 변수 설정

		try {
			int result = jdbcUtil.executeUpdate(); // delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}

	public Ingredient findIngredient(String ingredientId) throws SQLException {
		String sql = "SELECT * " + "FROM INGREDIENTINFO " + "WHERE INGREDIENTID=? ";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { ingredientId }); // JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			if (rs.next()) { // 재료 정보 발견
				Ingredient ingredient = new Ingredient( // recipe 객체를 생성하여 재료 정보를 저장
						rs.getInt("INGREDIENTID"), rs.getString("NAME"));
				return ingredient;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}

	/**
	 * 전체 재료 정보를 검색하여 List에 저장 및 반환
	 */
	public List<Ingredient> findIngredientList() throws SQLException {
		String sql = "SELECT * " + "FROM INGREDIENTINFO " + "ORDER BY INGREDIENTID";
		jdbcUtil.setSqlAndParameters(sql, null); // JDBCUtil에 query문 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			List<Ingredient> ingredientList = new ArrayList<Ingredient>(); // Ingredient들의 리스트 생성
			while (rs.next()) {
				Ingredient ingredient = new Ingredient( // recipe 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("INGREDIENTID"), rs.getString("NAME"));
				ingredientList.add(ingredient); // List에 recipe 객체 저장
			}
			return ingredientList;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}
	
	/**
	 * 전체 재료 정보를 검색한 후 현재 페이지와 페이지당 출력할 사용자 수를 이용하여
	 * 해당하는 재료 정보만을 List에 저장하여 반환.
	 */
	public List<Ingredient> findIngredientList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT * " 
					+ "FROM INGREDIENTINFO "
					+ "ORDER BY INGREDIENTID";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query 실행			
			int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
			if ((start >= 0) && rs.absolute(start)) {			// 커서를 시작 행으로 이동
				List<Ingredient> ingredientList = new ArrayList<Ingredient>();	// User들의 리스트 생성
				do {
					Ingredient ingredient = new Ingredient(			// User 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("INGREDIENTID"),
						rs.getString("NAME"));
					ingredientList.add(ingredient);							// 리스트에 User 객체 저장
				} while ((rs.next()) && (--countPerPage > 0));		
				return ingredientList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 주어진 재료이름에 해당하는 재료가 존재하는지 검사 
	 */
	public boolean existingIngredient(String name) throws SQLException {
		String sql = "SELECT count(*) FROM INGREDIENTINFO WHERE NAME=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {name});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}

}
