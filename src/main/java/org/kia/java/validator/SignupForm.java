package org.kia.java.validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class SignupForm {

	
	@NotEmpty
	@NotNull
	String name;
	
	@NotEmpty
	@NotNull
	String email;
	
	@NotEmpty
	@NotNull
	@Size(min=6)
	String password;
	
	@NotEmpty
	@NotNull
	String country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
}
