public class Review
{
	private static Review _instance = null;

	public static Review instance(String c) {
		if(_instance == null) {
			_instance = new Reviews(c);
		}
		return(_instance);
	}

	private String reviewText;
	private int rating;
	private int reviewerId;
	private int foodPlaceId;
	private String reviewDate;

	private Review(String r) {
		review = r;
	}

	public void setReviewText(String r) {
		review = r;
	}

	public String getReviewText() {
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

	public void setFoodPlaceId(int fpid) {
		foodPlaceId = fpid;
	}

	public int getFoodPlaceId() {
		return(foodPlaceId);
	}

	public void setReviewDate(String date) {
		reviewDate = date;
	}

	public String getReviewDate() {
		return(reviewDate);
	}
}
