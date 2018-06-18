public class Foodie extends Person
{
	private static Foodie _instance = null;

	public static Foodie instance(String fname, String lname, int a, String un, String pw, String em, String loc , String ff) {
		if(_instance == null) {
			_instance = new Foodie(fname, lname, a, un, pw, em, loc, ff); 
		}
		return(_instance);
	}
	
	private String favoriteFood;

	private Foodie(String fname, String lname, int a, String un, String pw, String em, String loc, String ff) {
		setFirstName(fname);
		setLastName(lname);
		setAge(a);
		setUsername(un);
		setPassword(pw);
		setEmail(em);
		setLocation(loc);
		favoriteFood = ff;
	}

	public void setFavoriteFood(String ff) {
		favoriteFood = ff;
	}

	public String getFavoriteFood() {
		return(favoriteFood);
	}

	public String toString() {
		return(super.toString() + " Favorite Food: " + favoriteFood);
	}
}
