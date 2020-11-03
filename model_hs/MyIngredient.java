package model;

public class MyIngredient {

	private String ingredientId;
	private int amount;
	private String unit;
	private Date expiredDate;
	
	public MyIngredient() { }
	
	public MyIngredient(String ingredientId, int amount, String unit, Date expiredDate) {
		super();
		this.ingredientId = ingredientId;
		this.amount = amount;
		this.unit = unit;
		this.expriredDate = expiredDate;
	}

	
	@Override
	public String toString() {
		return "MyIngredient [ingredientId=" + ingredientId + ", amount=" + amount + ", unit=" + unit + ", expiredDate=" + expiredDate + "]";
}