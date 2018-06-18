public class Foodie extends Person
{	
	private String favoriteFood;

	public Foodie(String fname, String lname, int a, String un, String pw, String em, String loc, String ff) {
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
