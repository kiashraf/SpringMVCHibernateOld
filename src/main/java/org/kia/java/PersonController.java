package org.kia.java;

import java.util.List;

import javax.validation.Valid;

import org.kia.java.model.Person;
import org.kia.java.repo.PersonRepo;
import org.kia.java.service.PersonService;
import org.kia.java.validator.SignupFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PersonController {

	private PersonService personService;
	private SignupFormValidator signupFormValidator;

	@Autowired
	public PersonController(PersonService personService,SignupFormValidator signupFormValidator) {
		this.personService = personService;
		this.signupFormValidator= signupFormValidator;
	}

	
	@InitBinder
	public void initSignupBinder(WebDataBinder binder){
		binder.setValidator(signupFormValidator);
		
	}
	/*@RequestMapping("/")
	@ResponseBody
	public String method(String name, String country) {
		Person person = null;

		try {
			person = new Person(name, country);
			personService.updatePerson(person);
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "person";
	}
*/
	@RequestMapping(value = {"/persons","/",""}, method = RequestMethod.GET)
	public ModelAndView listPersons(@ModelAttribute("person") Person person) {
		List<Person> listPersons = personService.listPersons();
		ModelAndView model = new ModelAndView("person", "listPersons", listPersons);

		return model;

	}

	/*@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {

		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());

		return "person";

	}*/

	@RequestMapping(value = "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") @Valid Person person,BindingResult result,RedirectAttributes redirectAttributes) {

		/*if (p.getId() == 0) {
			this.personService.addPerson(p);
		} else {

			this.personService.updatePerson(p);

		}*/
		if(result.hasErrors()){
			return "redirect:/persons";
		}
		
		personService.addAfterValidation(person);

		return "redirect:/persons";

	}

	@RequestMapping(value = "/person/add", method = RequestMethod.GET)
	public String newPerson(ModelMap model) {

		Person person = new Person();
		model.addAttribute("person", person);

		model.addAttribute("edit", false);
		return "person";

	}

	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") int id) {
		this.personService.removePerson(id);

		return "redirect:/persons";

	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {

		model.addAttribute("person", this.personService.getPersonById(id));
		model.addAttribute("listPersons", this.personService.listPersons());

		return "person";

	}

}
