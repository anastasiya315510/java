package telran.java29.person.service;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import telran.java29.person.dao.PersonRepository;
import telran.java29.person.dto.PersonDto;
import telran.java29.person.model.Address;
import telran.java29.person.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;
	
	private PersonDto convertToPersonDto(Person person) {
		return PersonDto.builder()
				.id(person.getId())
				.name(person.getName())
				.birthDate(person.getBirthDate().toString())
				.address(person.getAddress())
				.build();

	}

	private Person convertToPerson(PersonDto personDto) {
		return Person.builder()
				.id(personDto.getId())
				.name(personDto.getName())
				.birthDate(LocalDate.parse(personDto.getBirthDate()))
				.address(personDto.getAddress())
				.build();
	}

	@Transactional
	@Override
	public boolean addPerson(PersonDto personDto) {
		if (personRepository.existsById(personDto.getId())) {
			return false;
		}
		Person person = convertToPerson(personDto);
		personRepository.save(person);
		return true;
	}

	@Override
	public PersonDto findPersonById(int id) {
		Person person = personRepository.findById(id).orElse(null);
		return person == null ? null : convertToPersonDto(person);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<PersonDto> findPersonsByName(String name) {
		return personRepository.findByName(name)
				.map(this::convertToPersonDto)
				.collect(Collectors.toList());
	}

	@Override
	public Iterable<PersonDto> findPersonsByAges(int min, int max) {

		LocalDate from = LocalDate.now().minusYears(max);
		LocalDate to = LocalDate.now().minusYears(min);
		return personRepository.findByBirthDateBetween(from, to).stream()
				.map(this::convertToPersonDto)
				.collect(Collectors.toList());

	}

	@Override
	@Transactional
	public PersonDto updateAddress(int id, Address address) {
		Person person = personRepository.findById(id).orElse(null);
		if (person == null) {
			return null;
		}
		person.setAddress(address);
//		personRepository.save(person);
		return convertToPersonDto(person);
	}

}
