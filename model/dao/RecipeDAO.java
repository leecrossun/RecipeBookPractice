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
 * 레시피 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * RECIPEINFO 테이블에 사용자 정보를 추가, 수정, 삭제, 검색 수행 
 */
public class RecipeDAO {
private JDBCUtil jdbcUtil = null;
	
	public RecipeDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/**
	 * 레시피 관리 테이블에 새로운 레시피 생성.
	 */
	public int create(Recipe recipe) throws SQLException {
		String sql = "INSERT INTO RECIPEINFO(NAME, SUMMARY, INGREDIENT,NATION_NM, LEVEL_NM, IMAGE, USERID) VALUES (?, ?, ?, ?, ?, ?, ?)";	
		String ingredientList = StringUtils.join(recipe.getIngredient(),','); 
		Object[] param = new Object[] {recipe.getName(), recipe.getSummary(), ingredientList, recipe.getNATION_NM(), recipe.getLEVEL_NM(), recipe.getImage(), recipe.getUserId()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;			
	}

	/**
	 * 기존의 레시피 정보를 수정.
	 */
	public int update(Recipe recipe) throws SQLException {
		String sql = "UPDATE RECIPEINFO "
					+ "SET NAME=?, SUMMARY=?, INGREDIENT=?, NATION_NM=?, LEVEL_NM=?, IMAGE=?, USERID=? "
					+ "WHERE RECIPEID=?";
		String ingredientList = StringUtils.join(recipe.getIngredient(),','); 
		Object[] param = new Object[] {recipe.getName(),recipe.getSummary(),ingredientList, recipe.getNATION_NM(), recipe.getLEVEL_NM(), recipe.getImage(), recipe.getUserId(), recipe.getRecipeId()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 레시피 ID에 해당하는 사용자를 삭제.
	 */
	public int remove(String recipeId) throws SQLException {
		String sql = "DELETE FROM RECIPEINFO WHERE RECIPEID=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {recipeId});	// JDBCUtil에 delete문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 주어진 레시피 ID에 해당하는 레시피 정보를 데이터베이스에서 찾아 RECIPE 도메인 클래스에 
	 * 저장하여 반환.
	 */
	public Recipe findRecipe(String recipeId) throws SQLException {
        String sql = "SELECT * "
        			+ "FROM RECIPEINFO "
        			+ "WHERE RECIPEID=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {recipeId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 레시피 정보 발견
				Recipe recipe = new Recipe(		// Recipe 객체를 생성하여 학생 정보를 저장
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
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 전체 레시피 정보를 검색하여 List에 저장 및 반환
	 */
	public List<Recipe> findRecipeList() throws SQLException {
        String sql = "SELECT * " 
        		   + "FROM RECIPEINFO "
        		   + "ORDER BY RECIPEID";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Recipe> recipeList = new ArrayList<Recipe>();	// Recipe들의 리스트 생성
			while (rs.next()) {
				Recipe recipe = new Recipe(			// Recipe 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("RECIPEID"),
						rs.getString("NAME"),
						rs.getString("SUMMARY"),
						new ArrayList<>(Arrays.asList(rs.getString("recipe").split(","))),
						rs.getString("NATION_NM"),
						rs.getString("LEVEL_NM"),					
						rs.getString("IMAGE"),
						rs.getInt("USERID"));	
						recipeList.add(recipe);// List에 Recipe 객체 저장
			}		
			return recipeList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	/**
	 * 전체 재료 정보를 검색한 후 현재 페이지와 페이지당 출력할 사용자 수를 이용하여
	 * 해당하는 재료 정보만을 List에 저장하여 반환.
	 */
	public List<Recipe> findRecipeList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT * " 
					+ "FROM RECIPEINFO "
					+ "ORDER BY RECIPEID";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query 실행			
			int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
			if ((start >= 0) && rs.absolute(start)) {			// 커서를 시작 행으로 이동
				List<Recipe> recipeList = new ArrayList<Recipe>();	// User들의 리스트 생성
				do {
					Recipe recipe = new Recipe(		// Recipe 객체를 생성하여 학생 정보를 저장
							rs.getInt("RECIPEID"),
							rs.getString("NAME"),
							rs.getString("SUMMARY"),
							new ArrayList<>(Arrays.asList(rs.getString("recipe").split(","))),
							rs.getString("NATION_NM"),
							rs.getString("LEVEL_NM"),					
							rs.getString("IMAGE"),
							rs.getInt("USERID"));						// 리스트에 User 객체 저장
				} while ((rs.next()) && (--countPerPage > 0));		
				return recipeList;							
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
	public boolean existingRecipe(String name) throws SQLException {
		String sql = "SELECT count(*) FROM RECIPEINFO WHERE NAME=?";      
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
