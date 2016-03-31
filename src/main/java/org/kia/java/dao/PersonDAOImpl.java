package org.kia.java.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.kia.java.model.Person;
import org.kia.java.repo.PersonRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO{

	
	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
	
	public PersonDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	/*private SessionFactory sessionFactory;
	*/
	private PersonRepo personRepo;

        @Autowired
	public  PersonDAOImpl(PersonRepo personRepo){
		

		this.personRepo = personRepo;
	}
	
	
	@Override
	public void addPerson(Person p) {
		
	/*	Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		*/
		personRepo.save(p);
		logger.info("Saved Successfully, Person : "+p);
		
		
	}

	@Override
	public void updatePerson(Person p) {
/*		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);*/
		personRepo.save(p);
		logger.info("Update Successfully, Person : "+p);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPersons() {
		/*Session session = this.sessionFactory.getCurrentSession();
		List<Person> personsList = session.createQuery("from Person").list();
		*/
		List<Person> personsList = personRepo.findAll();
		for(Person p : personsList){
	            logger.info("Person List::"+p);
	        }
		
		
		return personsList;
	}

	@Override
	public Person getPersonById(int id) {
		/*Session session = this.sessionFactory.getCurrentSession();
		
		Person p = (Person) session.load(Person.class, new Integer(id));
		*/
		Person p = personRepo.findOne(id);
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removePerson(int id) {
		/*Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class,new Integer(id));
		*/
	 personRepo.delete(id);
	/*	 if(null != p){
	            session.delete(p);
	        }*/
	        logger.info("Person deleted successfully, person details="+personRepo.findOne(id));
		
		
		
	}

}
