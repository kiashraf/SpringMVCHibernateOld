package org.kia.java.validator;

import org.kia.java.model.Person;
import org.kia.java.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Component
public class SignupFormValidator extends LocalValidatorFactoryBean{

	private PersonRepo personRepo;
	
	@Autowired
	public SignupFormValidator( PersonRepo personRepo) {
	this.personRepo =personRepo;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(Person.class);
	}
	
	
	@Override
	public void validate(Object obj, Errors errors, Object... validationHints) {
	
		super.validate(obj, errors, validationHints);
		
		if(!errors.hasErrors()){
			
			//SignupForm signupForm = (SignupForm)obj;
			Person personFromSignup = (Person) obj;
			
			Person person = personRepo.findByEmail(personFromSignup.getEmail());
			
			if(person!=null){
				errors.rejectValue("email", "email error");
				
			}
		}
		
		
		
	}
	
	
}
