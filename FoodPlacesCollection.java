import java.util.ArrayList;

public class FoodPlacesCollection 
{
	ArrayList<FoodPlace> foodPlaces;

	public FoodPlacesCollection() {
		foodPlaces = new ArrayList<FoodPlace>();
	}

	public void addFoodPlace(FoodPlace FoodPlace) {
		foodPlaces.add(FoodPlace);
	}

	public void removeFoodPlace(FoodPlace FoodPlace) {
		foodPlaces.remove(FoodPlace);
	}

	public ArrayList<FoodPlace> getAllFoodPlaces() {
		return(foodPlaces);
	}

	public FoodPlace getFoodPlaceByIndex(int i) {
		return(foodPlaces.get(i));
	}
}
