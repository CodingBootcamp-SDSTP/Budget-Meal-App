public class Manager extends Person
{
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
