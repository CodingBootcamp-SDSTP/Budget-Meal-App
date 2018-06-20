import java.util.ArrayList;

public class ReviewCollection 
{
	private static ReviewCollection _instance = null;

	public static ReviewCollection instance() {
		if(_instance == null) {
			_instance = new ReviewCollection(); 
		}
		return(_instance);
	}

	ArrayList<Review> reviews;

	public ReviewCollection() {
		reviews = new ArrayList<Review>();
	}

	public void addReview(Review review) {
		reviews.add(review);
	}

	public void removeReview(Review review) {
		reviews.remove(review);
	}

	public ArrayList<Review> getAllReviews() {
		return(reviews);
	}

	public Review getReviewByIndex(int i) {
		return(reviews.get(i));
	}

	public int getReviewCount() {
		return(reviews.size());
	}

	public ArrayList<Review> search(String text) {
		Review r = null;
		ArrayList<Review> rc = new ArrayList<Review>();
		String str = text.toLowerCase();
		for(int i=0; i<getReviewCount(); i++) {
			r = getReviewByIndex(i);
			if(matches(r, str)) {
				rc.add(r);
			}
		}
		return(rc);
	}

	public boolean matches(Review r, String text) {
		String reviewText = r.getReviewText().toLowerCase();
		if(reviewText.contains(text)) {
			return(true);
		}
		return(false);
	}
}
