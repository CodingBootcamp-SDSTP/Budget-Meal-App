public class Manager extends Person
{
	private static Manager _instance = null;

	public static Manager instance(String loc , String ff) {
		if(_instance == null) {
			_instance = new Manager(loc, ff); 
		}
		return(_instance);
	}
	
	private String establishmentName;

	public Manager(String en) {
		establishmentName = en;
	}

	public void setEstablishmentName(String en) {
		establishmentName = en;
	}

	public String getEstablishmentName() {
		return(establishmentName);
	}

	public String toString() {
		return(super.toString() + " Food Place: " + establishmentName);
	}
}
