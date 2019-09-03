package telran.java29.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.java29.person.dto.PersonDto;
import telran.java29.person.model.Address;
import telran.java29.person.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@PostMapping
	public boolean addPerson(@RequestBody PersonDto personDto) {
		return personService.addPerson(personDto);
	}
	
	@GetMapping("/{id}")
	public PersonDto findPerson(@PathVariable int id) {
		return personService.findPersonById(id);
	}
	
	@GetMapping("/name/{name}")
	public Iterable<PersonDto> findSameNamePersons(@PathVariable String name) {
		return personService.findPersonsByName(name);
	}
	
	@GetMapping("/ages/{min}/{max}")
	public Iterable<PersonDto> findPersonsByAges(@PathVariable int min, @PathVariable int max) {
		return personService.findPersonsByAges(min, max);
	}
	
	@PutMapping("/address/{id}")
	public PersonDto updateAddress(@PathVariable int id, @RequestBody Address address) {
		return personService.updateAddress(id, address);
	}

}
