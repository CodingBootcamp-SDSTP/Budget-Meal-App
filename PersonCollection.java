import java.util.ArrayList;

public class PersonCollection 
{
	private static PersonCollection _instance = null;

	public static PersonCollection instance(String loc , String ff) {
		if(_instance == null) {
			_instance = new PersonCollection(loc, ff); 
		}
		return(_instance);
	}

	ArrayList<Person> persons;

	public PersonCollection() {
		persons = new ArrayList<Person>();
	}

	public void addPerson(Person person) {
		persons.add(person);
	}

	public void removePerson(Person person) {
		persons.remove(person);
	}

	public ArrayList<Person> getAllPersons() {
		return(persons);
	}

	public Person getPersonByIndex(int i) {
		return(persons.get(i));
	}
}
