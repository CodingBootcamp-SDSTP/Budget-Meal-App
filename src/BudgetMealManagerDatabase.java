import java.util.ArrayList;
import java.io.*;
import java.sql.*;
import java.math.BigDecimal;

public class BudgetMealManagerDatabase
{
	private static BudgetMealManagerDatabase _instance = null;

	public static BudgetMealManagerDatabase instance() {
		if(_instance == null) {
			_instance = new BudgetMealManagerDatabase();
		}
		return(_instance);
	}

	private PersonCollection persons;
	private FoodPlacesCollection foodPlaces;
	private ReviewCollection reviews;
	Connection conn = null;

	private BudgetMealManagerDatabase() {
		foodPlaces = FoodPlacesCollection.instance();
		persons = PersonCollection.instance();
		reviews = new ReviewCollection();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/budgetmeal?user=jcnebab&password=budgetmeal&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
			readFromSQL(conn);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void addPerson(Person person) {
		if(insertPersonToSQL(person)) {
			addPerson(person);
		}
	}

	public PersonCollection getPersonCollection() {
		return(persons);
	}

	public FoodPlacesCollection getFoodPlacesCollection() {
		return(foodPlaces);
	}

	public ReviewCollection getReviewCollection() {
		return(reviews);
	}

	public boolean insertPersonToSQL(Person person) {
		PreparedStatement stmt = null;
		try {
			if(person instanceof Foodie) {
				Foodie f = (Foodie)person;
				stmt = conn.prepareStatement("INSERT INTO persons_tbl ( firstname, lastname, age, username, password, email, location, food, persontype ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				stmt.setString(1, f.getFirstName());
				stmt.setString(2, f.getLastName());
				stmt.setInt(3, f.getAge());
				stmt.setString(4, f.getUsername());
				stmt.setString(5, f.getPassword());
				stmt.setString(6, f.getEmail());
				stmt.setString(7, f.getLocation());
				stmt.setString(8, f.getFavoriteFood());
				stmt.setString(9, "foodie");
				stmt.executeUpdate();
			}
			else if(person instanceof Manager) {
				Manager m = (Manager)person;
				stmt = conn.prepareStatement("INSERT INTO persons_tbl ( firstname, lastname, age, username, password, email, location, establishmentname, persontype ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				stmt.setString(1, m.getFirstName());
				stmt.setString(2, m.getLastName());
				stmt.setInt(3, m.getAge());
				stmt.setString(4, m.getUsername());
				stmt.setString(5, m.getPassword());
				stmt.setString(6, m.getEmail());
				stmt.setString(7, m.getLocation());
				stmt.setString(8, m.getEstablishmentName());
				stmt.setString(9, "manager");
				stmt.executeUpdate();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return(false);
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(true);
	}

	public boolean readFromSQL(Connection conn) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("SELECT * FROM persons_tbl");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String[] details = {
					rs.getString("firstname"),
					rs.getString("lastname"),
					rs.getString("age"),
					rs.getString("username"),
					rs.getString("password"),
					rs.getString("email"),
					rs.getString("location"),
					rs.getString("favoritefood"),
					rs.getString("establishmentname"),
					rs.getString("persontype")
				};
				createObject(details);
			}
			stmt = conn.prepareStatement("SELECT * FROM foodplaces_tbl");
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
			stmt = conn.prepareStatement("SELECT * FROM reviews_tbl");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String[] details = {
					rs.getString("reviewtext"),
					rs.getString("reviewrating"),
					rs.getString("reviewerid"),
					rs.getString("foodplaceid"),
					rs.getString("reviewdate"),
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
		int len = details.length - 1;
		String d = details[len];
		switch(d) {
			case "foodie":
				Foodie f = new Foodie(details[0], details[1], Integer.parseInt(details[2]), details[3], details[4], details[5], details[6], details[7]);
				persons.addPerson(f);
				break;
			case "manager":
				Manager m = new Manager(details[0], details[1], Integer.parseInt(details[2]), details[3], details[4], details[5], details[6], details[8]);
				persons.addPerson(m);
				break;
			case "foodplace":
				FoodPlace fp = new FoodPlace(details[0], details[1], (details[2]), new BigDecimal(details[3]));
				foodPlaces.addFoodPlace(fp);
				break;
			case "review":
				Review r = new Review(details[0], Integer.parseInt(details[1]), Integer.parseInt(details[2]), Integer.parseInt(details[3]), details[4]);
				reviews.addReview(r);
				break;
		}
	}

	public ArrayList<Object> search(BigDecimal a, String f, String l, String t) {
		ArrayList<Object> obj = new ArrayList<Object>();
		ArrayList<Person> p = persons.search(t);
		ArrayList<FoodPlace> fp = foodPlaces.search(a, f, l);
		ArrayList<Review> r = reviews.search(t);
		obj.addAll(p);
		obj.addAll(fp);
		obj.addAll(r);
		return(obj);
	}

	public String getCollectionContent() {
		ArrayList<Person> p = persons.getAllPersons();
		ArrayList<FoodPlace> fp = foodPlaces.getAllFoodPlaces();
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
		for(int i=0; i<r.size(); i++) {
			Review review = r.get(i);
			sb.append(review.toString());
			if(i < r.size()-1) {
				sb.append("\n");
			}
		}
		return(sb.toString());
	}
}
