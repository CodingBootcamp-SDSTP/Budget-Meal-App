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

	public ArrayList<FoodPlace> search(String text) {
		FoodPlace fp = null;
		ArrayList<FoodPlace> fpc = new ArrayList<FoodPlace>();
		String str = text.toLowerCase();
		for(int i=0; i<getFoodPlaceCount(); i++) {
			fp = getFoodPlaceByIndex(i);
			if(matches(fp, str)) {
				fpc.add(fp);
			}
		}
		return(fpc);
	}

	public boolean matches(FoodPlace fp, String str) {
		String loc = fp.getLocation().toLowerCase();
		String fpname = fp.getName().toLowerCase();
		String fave = fp.getFavoriteFood().toLowerCase();
		if(loc.contains(str) || fpname.contains(str) || fave.contains(str)) {
			return(true);
		}
		return(false);
	}
}
