package Controller;
import java.util.ArrayList;

public class MovieReviewController {
	
	private String movieName;
	private ArrayList<String> reviews,name;
	private static ArrayList<MovieReviewController> movieList;
	
	public MovieReviewController(String movieName){
		this.movieName=movieName;
		this.name=null;
		this.reviews=null;
		
	}
	
	
	public static void addReview(String movieName,String review) {
		int arrSize = movieList.size();
		movieName=movieName.toLowerCase();
		for (int i=0;i<arrSize;i++) {
			if (movieList.get(i).getName().toLowerCase().equals(movieName)) {
				movieList.get(i).setReview(review);
				break;
			}
		
		}
		System.out.println("Movie not found");
	}
	public static void addMovieForReview(String movieName) {
		MovieReviewController M = new MovieReviewController(movieName);
		movieList.add(M);
	}
	
	public static void printReview(String movieName) {
		int arrSize = movieList.size();
		movieName=movieName.toLowerCase();
		for (int i=0;i<arrSize;i++) {
			if (movieList.get(i).getName().toLowerCase().equals(movieName)) {
				int size = movieList.get(i).getReviews().size();
				for (int j=0;j<size;j++) {
					System.out.println(movieList.get(i).getReviews().get(j));
				}
				break;
			}
		
		}
		System.out.println("Movie not found");
		
	}
	
	public boolean checkMovie(String movieName) {
		int arrSize = movieList.size();
		movieName=movieName.toLowerCase();
		for (int i=0;i<arrSize;i++) {
			if (movieList.get(i).getName().toLowerCase().equals(movieName)) {
				return true;
			}
			
	 }
		return false;
	}
	
	public ArrayList<String> getReviews() {
		return this.reviews;
	}
	
	public void setReview(String reviews) {
		this.reviews.add(reviews);
	}
	
	public String getName() {
		return this.movieName;
	}

}
