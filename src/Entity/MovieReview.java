package Entity;



public class MovieReview {
	
	private double rating;
	private String review;
	private String name;

	public MovieReview(String name,String review, double rating) {
		this.name=name;
		this.review=review;
		this.rating=rating;
		
	}
	
	public String getReview() {
		return this.review;
	}
	
	public void setReview(String review) {
		this.review=review;
	}
	
	public double getRating() {
		return this.rating;
	}
	
	public void setRating() {
		this.rating=rating;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName() {
		this.name=name;
	}

}