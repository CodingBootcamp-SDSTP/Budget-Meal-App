public class Review
{
	private static Review _instance = null;

	public static Review instance(String c) {
		if(_instance == null) {
			_instance = new Reviews(c);
		}
		return(_instance);
	}

	private String review;
	private int rating;
	private int reviewerid;

	private Review(String r) {
		review = r;
	}

	public void setReview(String r) {
		review = r;
	}

	public String getReview() {
		return(review);
	}

	public void setRating(int r) {
		rating = r;
	}

	public int getRating() {
		return(rating);
	}

	public void setReviewerId(int rv) {
		reviewerid = rv;
	}

	public int getReviewerId() {
		return(reviewerid);
	}
}
