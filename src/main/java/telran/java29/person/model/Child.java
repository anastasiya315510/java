package telran.java29.person.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Child extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String kindergartenString;

	public Child(int id, String name, LocalDate birthDate, Address address, String kindergartenString) {
		super(id, name, birthDate, address);
		this.kindergartenString = kindergartenString;
	}

}
