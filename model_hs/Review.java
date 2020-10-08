package model;

public class Review {
	
	private int reviewId;
	private int recipeId;
	private String writer;
	private String contents;
	private double rating;
	
	public Review() { }
	
	public Review(int reviewId, int recipeId, String writer, String contents, double rating) {
		super();
		this.reviewId = reviewId;
		this.recipeId = recipeId;
		this.contents = contents;
		this.rating = rating;
		this.writer = writer;
	}
	
	public int getReviewId() { 
		return reviewId;
	}
	
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	
	public int getRecipeId() { 
		return recipeId;
	};
	
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	
	public String getWriter() { 
		return writer;
	};
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getContents() { 
		return contents;
	};
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public double getRating() { 
		return rating;
	}
	
	public void setRating() {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", recipeId=" + recipeId + ", writer=" + writer + ", contents=" + contents + ", rating=" + rating + "]";
	}
	
}
