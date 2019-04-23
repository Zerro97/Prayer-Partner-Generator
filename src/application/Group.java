package application;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Group {
	ArrayList<Person> group;
	
	StringProperty name;
	
	public Group() {
		group = new ArrayList<Person>();
	}
	
	public void addPerson(Person person) {
		group.add(person);
	}
	
	public void removePerson(Person person) {
		group.remove(person);
	}
	
	public StringProperty getName() {
		return name;
	}

	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}
}
