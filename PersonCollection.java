import java.util.ArrayList;

public class PersonCollection 
{
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
