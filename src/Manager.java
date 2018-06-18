public class Manager extends Person
{	
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
