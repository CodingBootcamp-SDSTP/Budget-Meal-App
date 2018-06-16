class FoodPlacesDatabase
{
	private static FoodPlacesDatabase _instance = null;

	public FoodPlacesDatabase instance() {
		if(_instance == null) {
			_instance = new FoodPlacesDatabase();
		}
		return(_instance);
	}

	ArrayList<PersonCollection> persons;
	ArrayList<FoodPlaceCollection> foodplaces;

	private FoodPlacesDatabase() {
		persons = new ArrayList<PersonCollection>();
		foodplaces = new ArrayList<FoodPlacesCollection>();
	}

	public void addPerson(Person person) {
		addPerson(person);
	}

	public void addFoodPlace(FoodPlace FoodPlace) {
		addFoodPlace(FoodPlace);
	}
}
