public class FoodPlace
{
	private static FoodPlace _instance = null;

	public static FoodPlace instance(String n, String a, String m, int p) {
		if(_instance == null) {
			_instance = new FoodPlace(n, a, m, p);
		}
		return(_instance);
	}
	
	private String name;
	private String address;
	private String cheapestMenu;
	private BigDecimal cheapestMenuPrice;
	private int rating;
	private String comment;

	private FoodPlace(String n, String a, String m, BigDecimal p) {
		name = m;
		address = a;
		cheapestMenu = m;
		cheapestMenuPrice = p;
	}

	public void setName(String n) {
		name = n;
	}

	public String getName() {
		return(name);
	}

	public void setAddress(String a) {
		address = a;
	}

	public String getAddress() {
		return(address);
	}

	public void setCheapestMenu(String m) {
		cheapestMenu = m;
	}

	public String getCheapestMenu() {
		return(cheapestMenu);
	}

	public void setCheapestMenuPrice(int p) {
		cheapestMenuPrice = p;
	}

	public BigDecimal getCheapestMenuPrice() {
		return(cheapestMenuPrice);
	}

	public void setRating(int r) {
		rating = r;
	}

	public int getRating() {
		return(rating);
	}

	public void setComment(String c) {
		comment = c;
	}

	public String getComment() {
		return(comment);
	}

	public String toString() {
		return(" Food Place: " + name + "\nAddress: " + address + "\nCheapest Menu: " +
		 cheapestMenu + "(" + lowestPrice + ")" + "\nRating: " + rating + " out of 5 stars" + "\nComment: " + comment);
	}
}
