import java.util.ArrayList;

public class FoodPlacesCollection 
{
	private static FoodPlacesCollection _instance = null;

	public static FoodPlacesCollection instance() {
		if(_instance == null) {
			_instance = new FoodPlacesCollection(); 
		}
		return(_instance);
	}

	ArrayList<FoodPlace> foodPlaces;

	private FoodPlacesCollection() {
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
