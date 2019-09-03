package telran.java29.person.service;

import telran.java29.person.dto.PersonDto;
import telran.java29.person.model.Address;

public interface PersonService {
	
	boolean addPerson(PersonDto personDto);
	
	PersonDto findPersonById(int id);

	Iterable<PersonDto> findPersonsByName(String name);

	Iterable<PersonDto> findPersonsByAges(int min, int max);

	PersonDto updateAddress(int id, Address address);

}
