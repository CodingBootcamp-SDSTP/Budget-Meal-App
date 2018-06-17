class FoodPlacesDatabase
{
	private static FoodPlacesDatabase _instance = null;

	public FoodPlacesDatabase instance() {
		if(_instance == null) {
			_instance = new FoodPlacesDatabase();
		}
		return(_instance);
	}

	private PersonCollection persons;
	private FoodPlacesCollection foodPlaces;
	Connection conn = null;

	private FoodPlacesDatabase() {
		foodPlaces = FoodPlacesCollection.instance();
		persons = new PersonCollection();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/assetcollection?user=nebab&password=nebabdb&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
			readFromSQL(conn);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void addPerson(Person person) {
		if(insertPersonToSQL) {
			addPerson(person);
		}
	}

	public void addFoodPlace(FoodPlace foodPlace) {
		if(insertFoodPlaceToSQL) {
			addFoodPlace(FoodPlace);
		}
	}

	public boolean insertPersonToSQL(Person person) {
		return(null);
	}

	public boolean insertFoodPlaceToSQL(FoodPlace foodPlace) {
		return(null);
	}

	public boolean readFromSQL(Connection conn) {
		PrepareStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement("SELECT * FROM persons");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String[] details = {
				};
				createObject(details);
			}
			stmt = conn.createStatement("SELECT * FROM foodplaces");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String[] details = {
				};
				createObject(details);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return(false);
		}
		return(true);
	}

	public void createObject(String... details) {
		int len = details.length -1;
		String d = details[len];
		if("foodie".equals(d)) {
			Foodie f = Foodie.instance();
			persons.addPerson(p);
		}
		else if("manager".equals(d)) {
			Manager m = Manager.instance();
			locations.addLocation(l);
		}
		else if("foodplace".equals(d)) {
			FoodPlace fp = FoodPlace.instance();
			assets.addAsset(b);
		}
	}

	public ArrayList<Object> search(String s) {
		ArrayList<Object> obj = new ArrayList<Object>();
		ArrayList<Person> p = persons.search(s);
		ArrayList<FoodPlace> fp = foodPlace.search(s);
		obj.addAll(p);
		obj.addAll(fp);
		return(obj);
	}
}
