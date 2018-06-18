import java.math.BigDecimal;

public class FoodPlace
{
	private String name;
	private String address;
	private String cheapestMenu;
	private BigDecimal cheapestMenuPrice;

	public FoodPlace(String n, String a, String m, BigDecimal p) {
		name = n;
		address = a;
		cheapestMenu = m;
		cheapestMenuPrice = p;
	}

	public void setName(String n) {
		name = n;
	}

	public String getName() {
		return(name);
	}

	public void setAddress(String a) {
		address = a;
	}

	public String getAddress() {
		return(address);
	}

	public void setCheapestMenu(String m) {
		cheapestMenu = m;
	}

	public String getCheapestMenu() {
		return(cheapestMenu);
	}

	public void setCheapestMenuPrice(BigDecimal p) {
		cheapestMenuPrice = p;
	}

	public BigDecimal getCheapestMenuPrice() {
		return(cheapestMenuPrice);
	}

	public String toString() {
		return(" Food Place: " + name + "\nAddress: " + address + "\nCheapest Menu: " +
		 cheapestMenu + "(" + cheapestMenuPrice + ")");
	}
}
