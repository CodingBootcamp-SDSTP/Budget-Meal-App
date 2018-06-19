import java.util.ArrayList;
import java.math.BigDecimal;

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

	public int getFoodPlacesCount() {
		return(foodPlaces.size());
	}

	public ArrayList<FoodPlace> search(BigDecimal amount, String ff, String loc) {
		FoodPlace fp = null;
		ArrayList<FoodPlace> fpc = new ArrayList<FoodPlace>();
		String fave = ff.toLowerCase();
		String l = loc.toLowerCase();
		for(int i=0; i<getFoodPlacesCount(); i++) {
			fp = getFoodPlaceByIndex(i);
			if(matches(fp, amount, fave, l)) {
				fpc.add(fp);
			}
		}
		return(fpc);
	}

	public boolean matches(FoodPlace fp, BigDecimal amount, String ff, String loc) {
		BigDecimal a = fp.getCheapestMenuPrice();
		String l = fp.getAddress().toLowerCase();
		String fave = fp.getCheapestMenu().toLowerCase();
		if((a.compareTo(amount)<=0 && l.contains(loc)) && (ff == "" || fave.contains(ff))) {
			return(true);
		}
		return(false);
	}
}
