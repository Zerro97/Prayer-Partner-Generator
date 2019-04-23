package application;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person extends RecursiveTreeObject<Person>{
	StringProperty name;
	StringProperty age;
	StringProperty email;
	StringProperty gender;
	
	public Person(String name, String age, String email, String gender) {
		this.name = new SimpleStringProperty(name);
		this.email = new SimpleStringProperty(email);
		this.age = new SimpleStringProperty(age);
		this.gender = new SimpleStringProperty(gender);
	}
	
	public Person() {
		this.name = new SimpleStringProperty("");
		this.email = new SimpleStringProperty("");
		this.age = new SimpleStringProperty("");
	}

	public StringProperty getName() {
		return name;
	}

	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}

	public StringProperty getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = new SimpleStringProperty(age);
	}

	public StringProperty getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = new SimpleStringProperty(email);
	}

	public StringProperty getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = new SimpleStringProperty(gender);
	}
}
