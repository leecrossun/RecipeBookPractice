package model;

public class User {

	private String userId;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String authority;
	private int fridgeId;
	private int numOfRecipes;
	private List<Recipe> recipeList;

	public User() { }
	
	public User(String userId, String password, String name, String email, String phone, String authority, int fridgeId, int numOfRecipes) {
		super(userId, password, name, email, phone);
		this.authority = authority;
		this.fridgeId = fridgeId;
		this.setNumOfRecipes(0);
	}
	
	public User(String userId, String password, String name, String email, String phone) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	public int getFridgeId() {
		return fridgeId;
	}
	
	public int setFridgeId(int fridgeId) {
		this.fridgeId = fridgeId;
	}
	
	public int getNumOfRecipes() {
		return numOfRecipes;
	}
	
	public void setNumOfRecipes(int numOfRecipes) {
		this.numOfRecipes = numOfRecipes;
	}
	
	public List<Recipe> getRecipeList() {
		return recipeList;
	}
	
	public void setRecipeList(List<Recipe> recipeList) {
		this.recipeList = recipeList;
	}

	/* 비밀번호 검사 */
	public boolean matchPassword(String password) {
		if (password == null) {
			return false;
		}
		return this.password.equals(password);
	}
	
	public boolean isSameUser(User user) {
        return userId.equals(user.userId);
    }
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email + ", phone="
				+ phone + ", authority=" + authority + ", fridgeId=" + fridgeId + ", numOfRecipes=" + numOfRecipes + "]";
}
