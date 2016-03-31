package org.kia.java.service;

import java.util.List;

import org.kia.java.dao.PersonDAO;
import org.kia.java.model.Person;
import org.kia.java.validator.SignupForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	/*@Autowired*/
	private PersonDAO personDAO;

	@Autowired
	public PersonServiceImpl(PersonDAO personDAO) {
		this.personDAO = personDAO;

	}

	@Override
	@Transactional
	public void addPerson(Person p) {
		this.personDAO.addPerson(p);

	}

	@Override
	@Transactional
	public void updatePerson(Person p) {

		this.personDAO.updatePerson(p);

	}

	@Override
	@Transactional
	public List<Person> listPersons() {
		// TODO Auto-generated method stub
		return this.personDAO.listPersons();
	}

	@Override
	@Transactional
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return this.personDAO.getPersonById(id);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		this.personDAO.removePerson(id);

	}

	@Override
	public void addAfterValidation(Person p) {
	
		Person person = new Person();
		
		person.setName(p.getName());
		person.setEmail(p.getEmail());
		person.setPassword(p.getPassword());
		person.setCountry(p.getCountry());
		
		personDAO.addPerson(person);
	}

}
