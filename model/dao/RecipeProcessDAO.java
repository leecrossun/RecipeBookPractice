package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RecipeProcess;

//클래스명을 process라고 하면 process객체 참조할 때 java.lang.process를 참조해서 이름을 바꿨습니다. 
/**
 * 요리과정 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * RECIPEPROCESSINFO 테이블에 요리과정 정보를 추가, 수정, 삭제, 검색 수행 
 */
public class RecipeProcessDAO {
	private JDBCUtil jdbcUtil = null;

	public RecipeProcessDAO() {
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성
	}

	/**
	 * 음식과정 관리 테이블에 새로운 재료 추가.
	 */
	public int create(RecipeProcess process) throws SQLException {
		String sql = "INSERT INTO RECIPEPROCESSTINFO(COOKINGCONTENTS, RECIPEID) VALUES (?,?)";
		Object[] param = new Object[] {process.getCookingContents(), process.getRecipeId() };
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
	 * 기존의 음식과정 정보를 수정.
	 */
	public int update(RecipeProcess process) throws SQLException {
		String sql = "UPDATE RECIPEPROCESSINFO " + "SET COOKINGCONTENTS=? " + "WHERE COOKINGNO=? AND RECIPEID=?";
		Object[] param = new Object[] { process.getCookingContents(), process.getCookingNo(), process.getRecipeId()};

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
	 * 레시피 ID에 해당하는 음식과정을 삭제.
	 */
	public int remove(String recipeId) throws SQLException {
		String sql = "DELETE FROM RECIPEPROCESSINFO WHERE RECIPEID=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { recipeId }); // JDBCUtil에 delete문과 매개 변수 설정

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

	public ArrayList<RecipeProcess> findRecipeProcess(String recipeId) throws SQLException {
		String sql = "SELECT * " + "FROM RECIPEPROCESSINFO " + "WHERE RECIPEID=? ORDER BY COOKINGNO";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { recipeId }); // JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			ArrayList<RecipeProcess> processList = new ArrayList<>(); 
			while (rs.next()) { // 재료 정보 발견
				RecipeProcess process = new RecipeProcess( // recipe 객체를 생성하여 재료 정보를 저장
						rs.getInt("COOKINGNO"), rs.getString("COOKINGCONTENTS"), rs.getInt("RECIPEID"));
				return processList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}

	/**
	 * 전체 요리과정 정보를 검색하여 List에 저장 및 반환
	 */
	public List<RecipeProcess> findRecipeProcessList() throws SQLException {
		String sql = "SELECT * " + "FROM RECIPEPROCESSINFO " + "ORDER BY RECIPEID, COOKINGNO";
		jdbcUtil.setSqlAndParameters(sql, null); // JDBCUtil에 query문 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			List<RecipeProcess> processList = new ArrayList<RecipeProcess>(); // RecipeProcess들의 리스트 생성
			while (rs.next()) {
				RecipeProcess process = new RecipeProcess( // recipe 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("COOKINGNO"), rs.getString("COOKINGCONTENTS"), rs.getInt("RECIPEID"));
				processList.add(process); // List에 recipe 객체 저장
			}
			return processList;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}
}
