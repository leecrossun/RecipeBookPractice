package model;

public class User {

	private String userId;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String authority;
	// 자신이 가지고 있는 재료 저장. 재료의 속성은 MyIngredient에서 정의
	private ArrayList<MyIngredient> ingredientList;
	// 즐겨찾기한 recipeId(String)를 저장
	private ArrayList<String> favorite;
	
	public User() { }
	
	public User(String userId, String password, String name, String email, String phone, String authority) {
		super(userId, password, name, email, phone);
		this.authority = authority;
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
	
	public ArrayList<MyIngredient> getIngredientList() {
		return ingredientList;
	}
	
	public void setIngredient(ArrayList<MyIngredient> ingredientList) {
		this.ingredientList = ingredientList;
	}
	
	public ArrayList<String> getFavorite() {
		return favorite;
	}
	
	public void setFavorite(ArrayList<String> favorite) {
		this.favorite = favorite;
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
				+ phone + ", authority=" + authority + "]";
}
