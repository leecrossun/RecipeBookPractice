package model;

public class Refridgerator {

	private int fridgeId;
	private String userId;
	private int numOfIngredients;
	private List<Ingredient> ingredientList;
	//private Date expriredDate;
	
	public Refridgerator() { }
	
	public Refridgerator(int fridgeId, String userId/*, Date expiredDate*/) {
		super();
		this.fridgeId = fridgeId;
		this.userId = userId;
		this.setNumOfIngredients(0);
		// this.expriredDate = expiredDate;
	}
	
	public int getFridgeId() {
		return fridgeId;
	}
	
	public void setFridgeId(int fridgeId) {
		this.fridgeId = fridgeId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public int getNumOfIngredients() {
		return numOfIngredients;
	}
	
	public void setNumOfIngredients(int numOfIngredients) {
		this.numOfIngredients = numOfIngredients;
	}
	
	public List<Ingredient> getIngredientList() {
		return ingredientList;
	}
	
	public void setIngredientList(List<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}
	
	@Override
	public String toString() {
		return "Refridgerator [fridgeId=" + fridgeId + ", userId=" + userId + ", name=" + name + ", numOfIngredients=" + numOfIngredients + "]";
}