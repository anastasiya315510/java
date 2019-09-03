package telran.java29.person.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import telran.java29.person.model.Address;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class PersonDto {
	int id;
	String name;
	String birthDate;
	Address address;

}
