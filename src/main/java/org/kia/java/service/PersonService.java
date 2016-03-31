package org.kia.java.service;

import java.util.List;

import org.kia.java.model.Person;
import org.kia.java.validator.SignupForm;

public interface PersonService {

	public void addPerson(Person p);
	
	public void updatePerson(Person p);
	
	public List<Person> listPersons();
	
	public Person getPersonById(int id);
	
	public void removePerson(int id);
	
	public void addAfterValidation(Person person);
	
	
	
	
	
	
	
}
