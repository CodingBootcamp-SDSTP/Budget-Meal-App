public class Manager extends Person
{
	private static Manager _instance = null;

	public static Manager instance(String fname, String lname, int a, String un, String pw, String em, String loc , String en) {
		if(_instance == null) {
			_instance = new Manager(fname, lname, a, un, pw, em, loc, en); 
		}
		return(_instance);
	}
	
	private String establishmentName;

	public Manager(String fname, String lname, int a, String un, String pw, String em, String loc , String en) {
		setFirstName(fname);
		setLastName(lname);
		setAge(a);
		setUsername(un);
		setPassword(pw);
		setEmail(em);
		setLocation(loc);
		establishmentName = en;
	}

	public void setEstablishmentName(String en) {
		establishmentName = en;
	}

	public String getEstablishmentName() {
		return(establishmentName);
	}

	@Override
	public String toString() {
		return(super.toString() + " Food Place: " + establishmentName);
	}
}
