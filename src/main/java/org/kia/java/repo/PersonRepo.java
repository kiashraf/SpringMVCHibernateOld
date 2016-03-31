package org.kia.java.repo;

import org.kia.java.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.lang.String;
import java.security.acl.Permission;
import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

	Person findByName(String name);

	Person findOne(Integer id);

	void delete(Person p);

	Person save(Person p);

	List<Person> findAll();
	
	Person findByEmail(String email);

}