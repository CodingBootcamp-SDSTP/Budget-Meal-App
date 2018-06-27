import java.sql.Date;

public class Review
{
	private String reviewText;
	private int rating;
	private int reviewerId;
	private int foodPlaceId;

	public Review(String rt, int r, int rid, int fpid) {
		reviewText = rt;
		rating = r;
		reviewerId = rid;
		foodPlaceId = fpid;
	}

	public void setReviewText(String rt) {
		reviewText = rt;
	}

	public String getReviewText() {
		return(reviewText);
	}

	public void setRating(int r) {
		rating = r;
	}

	public int getRating() {
		return(rating);
	}

	public void setReviewerId(int rv) {
		reviewerId = rv;
	}

	public int getReviewerId() {
		return(reviewerId);
	}

	public void setFoodPlaceId(int fpid) {
		foodPlaceId = fpid;
	}

	public int getFoodPlaceId() {
		return(foodPlaceId);
	}

	// public void setReviewDate(Timestamp date) {
	// 	reviewDate = date;
	// }

	// public Timestamp getReviewDate() {
	// 	return(reviewDate);
	// }
}
