public class Foodie extends Person
{
	private String favoriteFood;

	public Foodie(String loc, String ff) {
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
