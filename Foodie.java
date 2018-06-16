public class Foodie extends Person
{
	private static Foodie _instance = null;

	public static Foodie instance(String loc , String ff) {
		if(_instance == null) {
			_instance = new Foodie(loc, ff); 
		}
		return(_instance);
	}
	
	private String favoriteFood;

	private Foodie(String loc, String ff) {
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
