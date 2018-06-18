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
	private ReviewCollection reviews;
	Connection conn = null;

	private FoodPlacesDatabase() {
		foodPlaces = FoodPlacesCollection.instance();
		persons = new PersonCollection();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/foodplacesdb?user=jnebab&password=foodie&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
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

	public void addReview(Review review) {
		if(insertReviewToSQL) {
			addReview(review);
		}
	}

	public boolean insertPersonToSQL(Person person) {
		return(null);
	}

	public boolean insertFoodPlaceToSQL(FoodPlace foodPlace) {
		return(null);
	}

	public boolean insertReviewToSQL(Review review) {
		return(null);
	}

	public boolean readFromSQL(Connection conn) {
		PrepareStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement("SELECT * FROM persons_tbl");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String[] details = {
					rs.getString("firstname"),
					rs.getString("lastname"),
					rs.getInt("age"),
					rs.getString("username"),
					rs.getString("password"),
					rs.getString("email"),
					rs.getString("location"),
					rs.getString("favoritefood"),
					rs.getString("establishmentname"),
					rs.getString("type")
				};
				createObject(details);
			}
			stmt = conn.createStatement("SELECT * FROM foodplaces_tbl");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String[] details = {
					rs.getString("fpname"),
					rs.getString("fplocation"),
					rs.getString("fpmenuname"),
					rs.getString("fpmenuprice"),
					"foodplace"
				};
				createObject(details);
			}
			stmt = conn.createStatement("SELECT * FROM reviews_tbl");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String[] details = {
					rs.getString("reviewtext"),
					rs.getInt("reviewrating"),
					rs.getInt("reviewerid"),
					rs.getInt("foodplaceid"),
					rs.getDate("reviewdate"),
					"review"
				};
				createObject(details);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return(false);
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch (Exception e) {};
			try { if(rs != null) rs.close(); } catch (Exception e) {};
		}
		return(true);
	}

	public void createObject(String... details) {
		int len = details.length -1;
		String d = details[len];
		switch(d) {
			case "foodie":
				Foodie f = Foodie.instance(details[0], details[1], Integer.parseInt(details[2]), details[3], details[4], details[5], details[6], details[7]);
				persons.addPerson(f);
			case "manager":
				Manager m = Manager.instance(details[0], details[1], Integer.parseInt(details[2]), details[3], details[4], details[5], details[6], details[8]);
				persons.addPerson(m);
			case "foodplace":
				FoodPlace fp = FoodPlace.instance(details[0], details[1], (details[2]), Integer.parseInt(details[3]));
				foodPlaces.addFoodPlace(fp);
			case "review":
				Review r = Review.instance(details[0], details[1], details[2], Integer.parseInt(details[3]));
				reviews.addReview(b);
		}
	}

	public ArrayList<Object> search(String s) {
		ArrayList<Object> obj = new ArrayList<Object>();
		ArrayList<Person> p = persons.search(s);
		ArrayList<FoodPlace> fp = foodPlaces.search(s);
		ArrayList<Review> r = reviews.search(s);
		obj.addAll(p);
		obj.addAll(fp);
		obj.addAll(r);
		return(obj);
	}

	public String getCollectionContent() {
		ArrayList<Person> p = persons.getAllPersons();
		ArrayList<FoodPlace> fp = foodPersons.getAllFoodPlaces();
		ArrayList<Review> r= reviews.getAllReviews();
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<p.size(); i++) {
			Person person = p.get(i);
			sb.append(person.toString() + "\n");
		}
		for(int i=0; i<fp.size(); i++) {
			FoodPlace foodPlace = fp.get(i);
			sb.append(foodPlace.toString() + "\n");
		}
		for(int i=0; i<a.size(); i++) {
			Review review = r.get(i);
			sb.append(review.toString());
			if(i < a.size()-1) {
				sb.append("\n");
			}
		}
		return(sb.toString());
	}
}
