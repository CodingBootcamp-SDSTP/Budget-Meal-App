import java.sql.Date;

public class Review
{
	private String reviewText;
	private int rating;
	private int reviewerId;
	private int foodPlaceId;
	private String reviewDate;

	public Review(String rt, int r, int rid, int fpid, String d) {
		reviewText = rt;
		rating = r;
		reviewerId = rid;
		foodPlaceId = fpid;
		reviewDate = d;
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

	public void setReviewDate(String date) {
		reviewDate = date;
	}

	public String getReviewDate() {
		return(reviewDate);
	}
}
