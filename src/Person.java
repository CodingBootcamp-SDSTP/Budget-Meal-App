class Person
{
	private String firstName;
	private String lastName;
	private int age;
	private String username;
	private String password;
	private String email;
	private String location;

	public void setFirstName(String fn) {
		firstName = fn;
	}

	public String getFirstName() {
		return(firstName);
	}

	public void setLastName(String ln) {
		lastName = ln;
	}

	public String getLastName() {
		return(lastName);
	}

	public void setAge(int a) {
		age = a;
	}

	public int getAge() {
		return(age);
	}

	public void setUsername(String un) {
		username = un;
	}

	public String getUsername() {
		return(username);
	}

	public void setPassword(String pw) {
		password = pw;
	}

	public String getPassword() {
		return(password);
	}

	public void setEmail(String em) {
		email = em;
	}

	public String getEmail() {
		return(email);
	}

	public void setLocation(String loc) {
		location = loc;
	}

	public String getLocation() {
		return(location);
	}

	public String toString() {
		return("First Name: " + firstName + "\nLast Name: " + lastName + "\nAge: " + age
		 + "\nUsername: " + username + "\nPassword: " + password + "\nEmail: " +
		 email + "\nLocation: " + location);
	}
}